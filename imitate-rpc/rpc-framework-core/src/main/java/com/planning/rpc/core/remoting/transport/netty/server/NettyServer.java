package com.planning.rpc.core.remoting.transport.netty.server;

import com.planning.rpc.core.provider.ServiceProvider;
import com.planning.rpc.core.provider.ServiceProviderImpl;
import com.planning.rpc.core.registry.ServiceRegistry;
import com.planning.rpc.core.registry.ZkServiceRegistry;
import com.planning.rpc.core.remoting.dto.RpcRequest;
import com.planning.rpc.core.remoting.dto.RpcResponse;
import com.planning.rpc.core.remoting.transport.netty.codec.kryo.NettyKryoDecoder;
import com.planning.rpc.core.remoting.transport.netty.codec.kryo.NettyKryoEncoder;
import com.planning.rpc.core.serialize.kryo.KryoSerializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

/**
 * @author yxc
 * @since 2020-10-15 10:49
 **/
@Slf4j
public class NettyServer {

    private String host;
    private int port;
    private KryoSerializer kryoSerializer;
    private ServiceRegistry serviceRegistry;
    private ServiceProvider serviceProvider;

    public NettyServer(String host, int port) {
        this.host = host;
        this.port = port;
        kryoSerializer = new KryoSerializer();
        serviceRegistry = new ZkServiceRegistry();
        serviceProvider = new ServiceProviderImpl();
    }

    public <T> void publishService(T service, Class<T> serviceClass) {
        serviceProvider.addServiceProvider(service, serviceClass);
        serviceRegistry.registerService(serviceClass.getCanonicalName(), new InetSocketAddress(host, port));
        startNettyServer();
    }

    private void startNettyServer() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    // 客户端第一次请求的时候才会进行初始化
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) {
                            channel.pipeline().addLast(new NettyKryoDecoder(kryoSerializer, RpcRequest.class));
                            channel.pipeline().addLast(new NettyKryoEncoder(kryoSerializer, RpcResponse.class));
                            channel.pipeline().addLast(new NettyServerHandler());
                        }
                    })
                    // 表示系统用于临时存放已完成三次握手的请求的队列的最大长度, 如果连接建立频繁，服务器处理创建新连接较慢，可以适当调大这个参数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // TCP默认开启了 Nagle 算法，该算法的作用是尽可能的发送大数据快，减少网络传输。TCP_NODELAY 参数的作用就是控制是否启用 Nagle 算法。
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    // 是否开启 TCP 底层心跳机制
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // 绑定端口，同步等待绑定成功
            ChannelFuture future = bootstrap.bind(host, port).sync();
            // 等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("occur exception when start server:", e);
        } finally {
            log.error("shutdown bossGroup and workGroup");
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}