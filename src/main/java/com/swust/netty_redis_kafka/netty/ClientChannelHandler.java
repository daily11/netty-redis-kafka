package com.swust.netty_redis_kafka.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 一个自定义的客户端接收类，SimpleChannelInboundHandler里面的参数可以是自定义的其他类
 */
@ChannelHandler.Sharable
public class ClientChannelHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("客户端接收到信息：" + msg);
        System.out.println("------------------------------------");
//        ctx.channel().close();//测试用，实际情况接收后看情况是否关闭
    }
}