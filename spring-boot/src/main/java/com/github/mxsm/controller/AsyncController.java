package com.github.mxsm.controller;

import com.github.mxsm.processor.Test;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mxsm
 * @Date 2021/3/16
 * @Since
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private Test test;

    @PostConstruct
    public void init(){
        test.test();
    }

    private ExecutorService service = Executors.newFixedThreadPool(10);

    @GetMapping("/time")
    public void async(HttpServletRequest request, HttpServletResponse response){

        request.setAttribute(Globals.ASYNC_SUPPORTED_ATTR, true);

        request.getSession(true);
        AsyncContext asyncContext = request.startAsync();

        service.execute(new Task(asyncContext));
    }

    class Task implements Runnable{

        private AsyncContext asyncContext;

        public Task(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }
        @Override
        public void run() {
            try {
                PrintWriter writer = this.asyncContext.getResponse().getWriter();
                writer.println(System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(10);
                writer.println(System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.asyncContext.complete();
            }
        }
    }

}
