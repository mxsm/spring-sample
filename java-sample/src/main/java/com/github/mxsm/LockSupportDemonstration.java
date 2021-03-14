package com.github.mxsm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author mxsm
 * @Date 2021/2/15
 * @Since
 */
public class LockSupportDemonstration {

    public static void main(String[] args) throws Exception {

        BlockingQueue blockingQueue = new LinkedBlockingQueue<>();

        blockingQueue.take();

    }

    public void testPark() {
        LockSupport.parkNanos(TimeUnit.MINUTES.toNanos(10));
    }

    public void testParkObject() {
        LockSupport.parkNanos(this,TimeUnit.MINUTES.toNanos(10));
    }

}
