package com.swust.netty_redis_kafka.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import redis.clients.jedis.Jedis;

/**
 * 一个自定义的服务端接收类，SimpleChannelInboundHandler里面的参数可以是自定义的其他类
 */
public class ServerChannelHandler extends SimpleChannelInboundHandler<String> {
    Jedis jedisClient = new Jedis("127.0.0.1", 6379);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 打印客户端发送过来的数据
        System.out.println("服务端接收到信息：" + msg);

        // 向客户端反馈数据
        ctx.channel().writeAndFlush("好好干，我不会亏待你的！");

        // 向redis存入客户端发送过来的数据
        jedisClient.set("position", msg);
//        String str = jedisClient.get("position");
//        System.out.println(str);
    }
}