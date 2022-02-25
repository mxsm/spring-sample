package com.github.mxsm;

/**
 * @author mxsm
 * @date 2022/2/19 22:03
 * @Since 1.0.0
 */
public class ThreadNumTest {
    public static void main(String[] args) {
        for(int i = 0; i < 4; ++i){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    do {

                    }while (true);
                }
            }, "mxsm").start();
        }
        System.out.println("main函数运行结束");
    }
}
