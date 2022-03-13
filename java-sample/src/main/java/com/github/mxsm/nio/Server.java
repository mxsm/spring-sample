package com.github.mxsm.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author mxsm
 * @date 2022/3/10 23:26
 * @Since 1.0.0
 */
public class Server {

    public static void main(String[] args) throws Exception{
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8080);
        ssc.bind(hostAddress);
        ssc.configureBlocking(false);
        int ops = ssc.validOps();
        SelectionKey selectKy = ssc.register(selector, ops, null);
        for (;;) {
            int noOfKeys = selector.select();
            if(noOfKeys <= 0){
                continue;
            }
            Set selectedKeys = selector.selectedKeys();
            Iterator itr = selectedKeys.iterator();
            while (itr.hasNext()) {
                SelectionKey ky = (SelectionKey) itr.next();
                if (ky.isAcceptable()) {
                    SocketChannel client = ssc.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);

                }
                else if (ky.isReadable()) {

                    SocketChannel client = (SocketChannel) ky.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);
                    String output = new String(buffer.array()).trim();
                    System.out.println("接收客户端信息: " + output);
                    ByteBuffer byteBuffer1 = ByteBuffer.wrap(("时间戳："+System.currentTimeMillis()).getBytes(
                        StandardCharsets.UTF_8));
                    client.write(byteBuffer1);
                }
                itr.remove();
            }
        }
    }
}
