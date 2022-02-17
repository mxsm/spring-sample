package com.github.mxsm.thread;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mxsm
 * @date 2022/2/9 22:01
 * @Since 1.0.0
 *
 * -Xms5m
 * -Xmx5m
 */
public class Phenomena1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        executorService1.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
