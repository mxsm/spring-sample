package com.github.mxsm.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/**
 * @author mxsm
 * @date 2022/3/5 20:53
 * @Since 1.0.0
 */
public class ResponseDataDecoder extends ReplayingDecoder<ResponseData> {

    @Override
    protected void decode(ChannelHandlerContext ctx,
        ByteBuf in, List<Object> out) throws Exception {

        ResponseData data = new ResponseData();
        data.setIntValue(in.readInt());
        out.add(data);
    }
}
