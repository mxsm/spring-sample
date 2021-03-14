package com.github.mxsm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author mxsm
 * @Date 2021/1/21
 * @Since
 */
public class Header {

    public static void main(String[] args) {
        long nanosTimeout = TimeUnit.SECONDS.toNanos(10);
        long deadline = System.nanoTime() + nanosTimeout;
        for(;;){
            LockSupport.parkNanos(Header.class, nanosTimeout);
            System.out.println(1);
            if(deadline - System.nanoTime() < 0){
                return;
            }
        }
    }

    public  void biasedLock(){

        /*System.out.println("biasedLock方法执行................");
        System.out.println(ClassLayout.parseInstance(this).toPrintable());*/



    }

}
