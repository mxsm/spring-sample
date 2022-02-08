package com.github.mxsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.servlet.AsyncContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.Globals;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mxsm
 * @Date 2021/3/16
 * @Since
 */
@RestController
@RequestMapping("/longPolling")
public class LongPollingController {

    private ScheduledExecutorService service = new ScheduledThreadPoolExecutor(10);
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Queue<Task> queue = new ConcurrentLinkedQueue<>();

    private BlockingQueue<Boolean> blockingQueue = new LinkedBlockingQueue<>(1000);

    @PostConstruct
    public void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("init");
               for (;;){
                   try {
                       blockingQueue.take();
                       Task poll = null;
                       do{
                           poll = queue.poll();
                           if(poll != null){
                               poll.execute();
                           }
                       }while (poll != null);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }, "thread-mxsm").start();
    }

    @GetMapping("/time")
    public void async(HttpServletRequest request, HttpServletResponse response) {
       final AsyncContext asyncContext = request.startAsync();
        executorService.execute(new Task(asyncContext));
    }

    @GetMapping("/update")
    public void update() {
        blockingQueue.offer(true);
    }

    class Task implements Runnable {
        private AsyncContext asyncContext;
        public Task(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }
        @Override
        public void run() {
                service.schedule(new Runnable() {
                    @Override
                    public void run() {
                        boolean remove = queue.remove(Task.this);
                        System.out.println(remove);
                        try {
                            HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
                            response.setStatus(HttpServletResponse.SC_OK);
                            response.getWriter().println("22222");
                            System.out.println(123);
                            asyncContext.complete();
                        } catch (IOException e) {
                            e.printStackTrace();
                            asyncContext.complete();
                        }
                    }
                }, 4, TimeUnit.MINUTES);
            queue.add(this);
            System.out.println(3333);
        }

        public void execute(){
            try {
                HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().println("333333");
                System.out.println(123);
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

