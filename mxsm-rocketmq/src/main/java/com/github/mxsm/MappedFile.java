package com.github.mxsm;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * @author mxsm
 * @Date 2021/6/5
 * @Since
 */
public class MappedFile {

    public static void main(String[] args) throws Exception{

     
        File file = new File("C:\\Users\\mxsm\\store\\commitlog\\00000000000000000000");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(MapMode.READ_WRITE, 0, file.length());
        int totalSize = map.getInt();
        // 1 TOTALSIZE
        System.out.println("TOTALSIZE:"+totalSize);
        byte[] bytes = new byte[totalSize];
        map.get(bytes);
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        int msgLen = 4 //MAGICCODE
            + 4 //BODYCRC
            + 4 //QUEUEID
            + 4 //FLAG
            + 8 //QUEUEOFFSET
            + 8 //PHYSICALOFFSET
            + 4 //SYSFLAG
            + 8 //BORNTIMESTAMP
            + 8 //BORNHOST
            + 8 //STORETIMESTAMP
            + 8 //STOREHOSTADDRESS
            + 4 //RECONSUMETIMES
            + 8; //Prepared Transaction Offset
        //获取Body的长度
        byte[] bytes1 = new byte[4];
        wrap.position(msgLen);
        wrap.get(bytes1);
        int anInt = ByteBuffer.wrap(bytes1).getInt();
        byte[] bodyBytes = new byte[anInt];
        wrap.get(bodyBytes,0,bodyBytes.length);
        //打印Body
        System.out.println(new String(bodyBytes));
    }

}
