package com.github.mxsm.netty.channelhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import java.net.SocketAddress;
import java.util.Date;

/**
 * @author mxsm
 * @date 2022/3/13 13:50
 * @Since 1.0.0
 */
public class TimeClientOutHandler extends ChannelOutboundHandlerAdapter {

    /**
     * Calls {@link ChannelHandlerContext#bind(SocketAddress, ChannelPromise)} to forward to the next {@link
     * ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     * @param localAddress
     * @param promise
     */
    @Override
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--bind");
        super.bind(ctx, localAddress, promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#connect(SocketAddress, SocketAddress, ChannelPromise)} to forward to the next
     * {@link ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     * @param remoteAddress
     * @param localAddress
     * @param promise
     */
    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress,
        ChannelPromise promise) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--connect");
        super.connect(ctx, remoteAddress, localAddress, promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#disconnect(ChannelPromise)} to forward to the next {@link
     * ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     * @param promise
     */
    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--disconnect");
        super.disconnect(ctx, promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#close(ChannelPromise)} to forward to the next {@link ChannelOutboundHandler}
     * in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     * @param promise
     */
    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--close");
        super.close(ctx, promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#deregister(ChannelPromise)} to forward to the next {@link
     * ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     * @param promise
     */
    @Override
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--deregister");
        super.deregister(ctx, promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#read()} to forward to the next {@link ChannelOutboundHandler} in the {@link
     * ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--read");
        super.read(ctx);
    }

    /**
     * Calls {@link ChannelHandlerContext#write(Object, ChannelPromise)} to forward to the next {@link
     * ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     * @param msg
     * @param promise
     */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--write");
        super.write(ctx, msg, promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#flush()} to forward to the next {@link ChannelOutboundHandler} in the {@link
     * ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--flush");
        super.flush(ctx);
    }

    /**
     * Do nothing by default, sub-classes may override this method.
     *
     * @param ctx
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--handlerAdded");
        super.handlerAdded(ctx);
    }

    /**
     * Do nothing by default, sub-classes may override this method.
     *
     * @param ctx
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--handlerRemoved");
        super.handlerRemoved(ctx);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireExceptionCaught(Throwable)} to forward to the next {@link ChannelHandler}
     * in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     * @param cause
     * @deprecated is part of {@link ChannelInboundHandler}
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--exceptionCaught");
        super.exceptionCaught(ctx, cause);
    }
}
