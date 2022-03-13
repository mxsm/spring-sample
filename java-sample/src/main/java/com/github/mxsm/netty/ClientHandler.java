package com.github.mxsm.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author mxsm
 * @date 2022/3/5 20:53
 * @Since 1.0.0
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx)
        throws Exception {

        RequestData msg = new RequestData();
        msg.setIntValue(123);
        msg.setStringValue(
            "all work and no play makes jack a dull boy");
        ChannelFuture future = ctx.writeAndFlush(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
        throws Exception {
        System.out.println((ResponseData)msg);
        ctx.close();
    }
}
