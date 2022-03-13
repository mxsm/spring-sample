package com.github.mxsm;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import java.util.concurrent.TimeUnit;

/**
 * @author mxsm
 * @date 2022/3/5 21:28
 * @Since 1.0.0
 */
public class NettyClientDemo {

    public static void main(String[] args) {
        for(int i = 0; i < 10; ++i){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new NettyClientDemo().test();
                }
            }, "mxsm"+i).start();
        }
    }

    public void test(){
        // 客户端就只需要创建一个 线程组了
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        // 创建 启动器
        Bootstrap bootstrap = new Bootstrap();
        try{
            // 设置相关的参数
            bootstrap.group(loopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new NettyClientHandler());
                    }
                });
            // 连接服务
            ChannelFuture future = bootstrap.connect("localhost",8080).sync();
            for(;;){
                future.channel().writeAndFlush(Unpooled.copiedBuffer("mxsm"+System.currentTimeMillis()+"\n", CharsetUtil.UTF_8));
                TimeUnit.SECONDS.sleep(1);
            }
            // 对服务关闭 监听
            //future.channel().closeFuture().sync();
        }catch (Exception e){

        }finally {
            loopGroup.shutdownGracefully();
        }
    }
}
