package com.planning.rpc.core.handler;

import com.planning.rpc.core.provider.ServiceProvider;
import com.planning.rpc.core.provider.ServiceProviderImpl;
import com.planning.rpc.core.remoting.dto.RpcRequest;
import com.planning.rpc.core.remoting.dto.RpcResponse;
import com.planning.rpc.enumeration.RpcResponseCode;
import com.planning.rpc.exception.RpcException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yxc
 * @since 2020-10-20 15:47
 **/
@Slf4j
public class RpcRequestHandler {

    private static ServiceProvider serviceProvider = new ServiceProviderImpl();

    public Object handle(RpcRequest rpcRequest) {
        Object service = RpcRequestHandler.serviceProvider.getServiceProvider(rpcRequest.getInterfaceName());
        return invokeTargetMethod(rpcRequest, service);
    }

    /**
     * 根据 rpcRequest 和 service 对象特定的方法并返回结果
     *
     * @param rpcRequest 客户端请求
     * @param service    提供服务的对象
     * @return 目标方法执行的结果
     */
    private Object invokeTargetMethod(RpcRequest rpcRequest, Object service) {
        Object result;
        try {
            Method method = service.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParamTypes());
            if (null == method) {
                return RpcResponse.fail(RpcResponseCode.NOT_FOUND_METHOD);
            }
            result = method.invoke(service, rpcRequest.getParameters());
            log.info("service: [{}] successful invoke method: [{}]", rpcRequest.getInterfaceName(), rpcRequest.getMethodName());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RpcException(e.getMessage(), e);
        }
        return result;
    }

}