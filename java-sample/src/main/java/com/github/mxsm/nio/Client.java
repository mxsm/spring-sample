package com.github.mxsm.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author mxsm
 * @date 2022/3/10 23:30
 * @Since 1.0.0
 */
public class Client {

    public static void main(String[] args) throws Exception{
        InetSocketAddress hA = new InetSocketAddress("localhost", 8080);
        SocketChannel client = SocketChannel.open(hA);
        System.out.println("The Client is sending messages to server...");

        for (;;) {
            ByteBuffer buffer = ByteBuffer.wrap(("客户端时间戳："+System.currentTimeMillis()).getBytes(
                StandardCharsets.UTF_8));
            client.write(buffer);
            buffer.clear();
            ByteBuffer buffer1 = buffer.allocate(256);
            client.read(buffer1);
            System.out.println("接收服务器消息："+new String(buffer1.array(), StandardCharsets.UTF_8).trim());
            TimeUnit.SECONDS.sleep(3);
        }

    }
}
