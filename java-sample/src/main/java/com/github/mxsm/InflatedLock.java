package com.github.mxsm;

import java.util.concurrent.TimeUnit;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author mxsm
 * @Date 2021/1/26
 * @Since
 */
public class InflatedLock {

    public static void main(String[] args) {
        //偏向锁延迟开启的状态下
        final Header headerView = new Header();
        System.out.println("加锁之前.....");
        System.out.println(ClassLayout.parseInstance(headerView).toPrintable());

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (headerView){
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("------ Thread1 release-----\n");
                    System.out.println(ClassLayout.parseInstance(headerView).toPrintable());
                }
            }
        },"Thread1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread1 is locking");
        System.out.println(ClassLayout.parseInstance(headerView).toPrintable());


        headerView.biasedLock();
        System.out.println("加锁之后.....");
        System.out.println(ClassLayout.parseInstance(headerView).toPrintable());

        System.gc();
        System.out.println("GC后.....");
        System.out.println(ClassLayout.parseInstance(headerView).toPrintable());
    }

}
