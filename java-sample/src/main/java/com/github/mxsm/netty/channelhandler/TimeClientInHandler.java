package com.github.mxsm.netty.channelhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.Date;

/**
 * @author mxsm
 * @date 2022/3/13 13:50
 * @Since 1.0.0
 */
public class TimeClientInHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(this.getClass().getSimpleName()+"--channelRead");
        ByteBuf m = (ByteBuf) msg; // (1)
        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        } finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println(this.getClass().getSimpleName()+"--exceptionCaught");
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelRegistered()} to forward to the next {@link ChannelInboundHandler}
     * in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--channelRegistered");
        super.channelRegistered(ctx);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelUnregistered()} to forward to the next {@link
     * ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--channelUnregistered");
        super.channelUnregistered(ctx);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelActive()} to forward to the next {@link ChannelInboundHandler} in
     * the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--channelActive");
        super.channelActive(ctx);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelInactive()} to forward to the next {@link ChannelInboundHandler} in
     * the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--channelInactive");
        super.channelInactive(ctx);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelReadComplete()} to forward to the next {@link
     * ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--channelReadComplete");
        super.channelReadComplete(ctx);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireUserEventTriggered(Object)} to forward to the next {@link
     * ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     * @param evt
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--userEventTriggered");
        super.userEventTriggered(ctx, evt);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelWritabilityChanged()} to forward to the next {@link
     * ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx
     */
    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this.getClass().getSimpleName()+"--channelWritabilityChanged");
        super.channelWritabilityChanged(ctx);
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
}
