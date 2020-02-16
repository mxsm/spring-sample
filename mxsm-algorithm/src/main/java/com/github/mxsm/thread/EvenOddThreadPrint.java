package com.github.mxsm.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/2/12 10:34
 */
public class EvenOddThreadPrint {
    static int count = 1;

    public static void main(String[] args) throws Exception {
        Semaphore oddSemaphore = new Semaphore(1);
        Semaphore evenSemaphore = new Semaphore(1);

        //启动奇数
        oddSemaphore.acquire();
        new Thread(new OddThread(oddSemaphore,evenSemaphore),"odd").start();


        new Thread(new EvenThread(oddSemaphore,evenSemaphore),"even").start();


    }

    /**
     * 偶数
     */
    static class EvenThread implements Runnable {

        private Semaphore oddSemaphore;

        private Semaphore evenSemaphore;


        public EvenThread(Semaphore oddSemaphore, Semaphore evenSemaphore) {
            this.oddSemaphore = oddSemaphore;
            this.evenSemaphore = evenSemaphore;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used to create a thread, starting the thread
         * causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            try {
                evenSemaphore.acquire();
                while (true) {

                    if(count % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + " 偶数 " + count);
                        count++;
                        if (count > 20) {
                            return;
                        }
                        oddSemaphore.release();
                        evenSemaphore.acquire();
                        TimeUnit.SECONDS.sleep(1);
                    }
                    if (count > 20) {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 奇数
     */
    static class OddThread implements Runnable {

        private Semaphore oddSemaphore;

        private Semaphore evenSemaphore;


        public OddThread(Semaphore oddSemaphore, Semaphore evenSemaphore) {
            this.oddSemaphore = oddSemaphore;
            this.evenSemaphore = evenSemaphore;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used to create a thread, starting the thread
         * causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            try {
                evenSemaphore.acquire();
                while (true) {
                    if(count % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + " 奇数 " + count);
                        count++;
                        if (count > 20) {
                            return;
                        }
                        evenSemaphore.release();
                        oddSemaphore.acquire();
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
