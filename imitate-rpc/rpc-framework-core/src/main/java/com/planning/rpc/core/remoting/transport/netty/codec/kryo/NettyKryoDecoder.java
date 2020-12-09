package com.planning.rpc.core.remoting.transport.netty.codec.kryo;

import com.planning.rpc.core.serialize.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 自定义解码器。负责处理入站消息，将消息格式转换为我们所需要的业务对象
 *
 * @author yxc
 * @since 2020-10-15 14:53
 **/
@AllArgsConstructor
@Slf4j
public class NettyKryoDecoder extends ByteToMessageDecoder {

    private Serializer serializer;
    private Class<?> genericClass;

    /**
     * Netty 传递的消息长度，就是对象序列化后对应的字节数组的大小，存储在 ByteBuf 头部
     */
    private static final int BODY_LENGTH = 4;

    /**
     * 解码 ByteBuf 对象
     *
     * @param channelHandlerContext 解码器关联的 channelHandleContext 对象
     * @param in                    “入站” 数据，也就是 ByteBuf 对象
     * @param out                   解码之后的数据对象需要添加到 out 对象里面
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) {
        // 对象序列化 字节数组 最小值为 4
        if (in.readInt() < 0 || in.readableBytes() < 0 || in.readableBytes() < BODY_LENGTH) {
            log.info("data length or byteBuf readleBytes is not valid");
            return;
        }
        // 标记当前
        in.markReaderIndex();
        int dataLength = in.readInt();

        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }

        byte[] body = new byte[dataLength];
        in.readBytes(body);
        Object obj = serializer.deserialize(body, genericClass);
        out.add(obj);
        log.info("successful decode ByteBuf to Object");
    }
}