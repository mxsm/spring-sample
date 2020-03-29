package com.github.mxsm;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 */
public class App {

    private static final int COUNT_BITS = Integer.SIZE - 3;

    public static void main(String[] args) throws Exception{
        //System.out.println(Integer.toBinaryString(1 << COUNT_BITS));

        RandomAccessFile file = new RandomAccessFile("C:\\Users\\mxsm\\Desktop\\MQ\\test.log", "rw");
        MappedByteBuffer mappedByteBuffer = file.getChannel().map(MapMode.READ_WRITE,0, 1024L*1204L*10L);
        /*String test = "test";
        mappedByteBuffer.put(test.getBytes(),0,test.getBytes().length);
        file.close();*/
        byte[] bytes = new byte[2];
        mappedByteBuffer.get(bytes,2,2);
        System.out.println(new String(bytes));
        CountDownLatch latch = new CountDownLatch(5);

    }

    public void test(){
        synchronized (App.class){
            System.out.println(111);

        }
    }
}
