package com.planning.rpc.core.remoting.transport.netty.client;

import com.planning.rpc.core.remoting.dto.RpcResponse;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yxc
 * @since 2020-10-23 14:17
 **/
public class UnprocessedRequests {

    private static Map<String, CompletableFuture<RpcResponse>> unprocessedResponseFutures = new ConcurrentHashMap<>();


}