package com.github.mxsm.netty.channelhandler;

import com.github.mxsm.netty.TimeClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author mxsm
 * @date 2022/3/13 13:53
 * @Since 1.0.0
 */
public class TimeClient {
    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = Integer.parseInt("8080");
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientOutHandler());
                    ch.pipeline().addLast(new TimeClientInHandler());
                }
            });

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)
            ByteBuf byteBuf = Unpooled.buffer();
            // Wait until the connection is closed.
            byteBuf.writeBytes("1111".getBytes(StandardCharsets.UTF_8));
            f.channel().writeAndFlush(byteBuf);

            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
