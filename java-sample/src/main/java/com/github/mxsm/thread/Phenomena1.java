package com.github.mxsm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mxsm
 * @date 2022/2/9 22:01
 * @Since 1.0.0
 */
public class Phenomena1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
            private AtomicInteger num = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "mxsm-"+num.getAndIncrement());
                t.setDaemon(true);
                return t;
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Runnable start");
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("Runnable end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("主线程结束");
    }
}
