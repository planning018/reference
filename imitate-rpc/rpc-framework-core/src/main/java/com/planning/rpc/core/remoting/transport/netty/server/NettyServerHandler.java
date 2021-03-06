package com.planning.rpc.core.remoting.transport.netty.server;

import com.planning.rpc.core.handler.RpcRequestHandler;
import com.planning.rpc.core.remoting.dto.RpcRequest;
import com.planning.rpc.core.remoting.dto.RpcResponse;
import com.planning.rpc.factory.SingletonFactory;
import com.planning.rpc.utils.concurrent.threadpool.CustomThreadPoolConfig;
import com.planning.rpc.utils.concurrent.threadpool.ThreadPoolFactoryUtils;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;

/**
 * 自定义服务端的 ChannelHandler 来处理客户端发过来的数据
 * <p>
 * 如果继承自 SimpleChannelInboundHandler 的话，就不用考虑 ByteBuf 的释放，内部的 channelRead 方法会替你释放 ByteBuf, 避免可能导致内存泄露问题
 *
 * @author yxc
 * @since 2020-10-15 10:49
 **/
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private static final String THREAD_NAME_PREFIX = "netty-server-handler-rpc-pool";
    private final RpcRequestHandler rpcRequestHandler;
    private final ExecutorService threadPool;

    public NettyServerHandler() {
        this.rpcRequestHandler = SingletonFactory.getInstance(RpcRequestHandler.class);
        CustomThreadPoolConfig customThreadPoolConfig = new CustomThreadPoolConfig();
        customThreadPoolConfig.setCorePoolSize(6);
        this.threadPool = ThreadPoolFactoryUtils.createCustomThreadPoolIfAbsent(customThreadPoolConfig, THREAD_NAME_PREFIX);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        threadPool.execute(() -> {
            try {
                log.info("server receive msg: [{}]", msg);
                RpcRequest request = (RpcRequest) msg;
                // 执行目标方法，并且返回结果
                Object result = rpcRequestHandler.handle(request);
                log.info(String.format("server get result: %s", result.toString()));
                if (ctx.channel().isActive() && ctx.channel().isWritable()) {
                    // 返回方法执行结果给客户端
                    RpcResponse<Object> rpcResponse = RpcResponse.success(request.getRequestId(), result);
                    ctx.writeAndFlush(rpcResponse).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                } else {
                    log.error("not writable now, message dropped");
                }
            } finally {
                // 确保 ByteBuf 被释放，不然可能会有内存泄露问题
                ReferenceCountUtil.release(msg);
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("server catch exception");
        cause.printStackTrace();
        ctx.close();
    }
}