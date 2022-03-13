package com.github.mxsm;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author mxsm
 * @date 2022/3/5 21:26
 * @Since 1.0.0
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取客户端发送来的数据
     * @param ctx ChannelHandler的上下文对象 有管道 pipeline 通道 channel 和 请求地址 等信息
     * @param msg 客户端发送的具体数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端请求到了..." + ctx.channel().remoteAddress());
        ByteBuf buf = (ByteBuf) msg;

        System.out.println("客户端发送的数据是:" +buf.toString(CharsetUtil.UTF_8));

    }

    /**
     * 读取客户端发送数据完成后的方法
     *    在本方法中可以发送返回的数据
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // writeAndFlush 是组合方法
        ctx.writeAndFlush(Unpooled.copiedBuffer("你好啊，客户端....^_^",CharsetUtil.UTF_8));
    }
}
