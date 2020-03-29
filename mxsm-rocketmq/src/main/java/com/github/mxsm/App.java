package com.github.mxsm;

import org.apache.rocketmq.common.UtilAll;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println(UtilAll.getPid());
        new Thread(()-> System.out.println(UtilAll.getPid())).start();
        new Thread(()-> System.out.println(UtilAll.getPid())).start();
    }
}
