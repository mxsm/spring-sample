package com.github.mxsm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mxsm
 * @date 2022/2/1 22:49
 * @Since 1.0.0
 *
 * 设置内存大小
 * -Xmx2m
 * -Xms2m
 *
 */
public class ThreadPoolExceptionTest {


    public static void main(String[] args) {

        try {
            new ThreadPoolExceptionTest().test2();
        } catch (Exception e) {

        }

    }

    public void test3(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        final AtomicInteger integer = new AtomicInteger();
        for(int i = 0;i <= 100000; ++i){
            final  int b = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(integer.getAndIncrement());
                        TimeUnit.SECONDS.sleep(b);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("主线程结束");
    }

    public void test2(){
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 100, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1),new ThreadFactory(){
            AtomicInteger integer = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "mxsm-"+integer.getAndIncrement());
            }
        });
        for(int i = 0; i < 3; ++i){
            final int b = i;
            executorService.execute(() -> {
                for (;;){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName()+ b +" 当前时间："+System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("主线程结束");
    }

    public void test1(){
        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
            AtomicInteger integer = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "mxsm-"+integer.getAndIncrement());
            }
        });
        executorService.execute(() -> {
            System.out.println(1);
            int i = 1/0;
            System.out.println(i);
        });
/*        executorService.execute(() -> {
            for (;;){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+" 当前时间："+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/
        System.out.println("主线程执行完成");
    }
}
