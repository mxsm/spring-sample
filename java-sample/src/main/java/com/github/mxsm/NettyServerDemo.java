package com.github.mxsm;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mxsm
 * @date 2022/3/5 21:27
 * @Since 1.0.0
 */
public class NettyServerDemo {
    public static void main(String[] args) {
        // 创建对应的 线程池
        // 创建Boss group
        EventLoopGroup boosGroup = new NioEventLoopGroup(1, new ThreadFactory() {

            private AtomicInteger integer = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread-boss-mxsm-"+integer.getAndIncrement());
            }
        });
        // 创建 workgroup
        EventLoopGroup workGroup = new NioEventLoopGroup(2, Executors.newSingleThreadExecutor(new ThreadFactory() {
            private AtomicInteger integer = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread-work-mxsm-"+integer.getAndIncrement());
            }
        }));
        // 创建对应的启动类
        ServerBootstrap bootstrap = new ServerBootstrap();
        try{
            // 设置相关的配置信息
            bootstrap.group(boosGroup,workGroup) // 设置对应的线程组
                .channel(NioServerSocketChannel.class) // 设置对应的通道
                .option(ChannelOption.SO_BACKLOG,1024) // 设置线程的连接个数
                .childHandler(new ChannelInitializer<SocketChannel>() { // 设置
                    /**
                     * 给pipeline 设置处理器
                     * @param socketChannel
                     * @throws Exception
                     */
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new NettyServerHandler());
                    }
                });
            System.out.println("服务启动了....");
            // 绑定端口  启动服务
            ChannelFuture channelFuture = bootstrap.bind(8080).sync();
            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){

        }finally {
            // 优雅停服
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
