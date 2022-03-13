package com.github.mxsm.netty.channelhandler;

import com.github.mxsm.netty.DiscardServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author mxsm
 * @date 2022/3/13 10:47
 * @Since 1.0.0
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.childHandler(new ChannelInitializer<SocketChannel>(){

                /**
                 * This method will be called once the {@link Channel} was registered. After the
                 * method returns this instance will be removed from the {@link ChannelPipeline}
                 * of the {@link Channel}.
                 *
                 * @param ch the {@link Channel} which was registered.
                 * @throws Exception is thrown if an error occurs. In that case it will be
                 *                   handled by {@link #exceptionCaught(ChannelHandlerContext,
                 *                   Throwable)} which will by default close the {@link
                 *                   Channel}.
                 */
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeServerBossOutHandler());
                    ch.pipeline().addLast(new TimeServerBossInHandler());
                }
            });
            b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class) // (3)
                .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new TimeServerOutHandler());
                        ch.pipeline().addLast(new TimeServerInHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync(); // (7)

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new DiscardServer(port).run();
    }
}
