package com.planning.rpc.core.remoting.dto;

import com.planning.rpc.enumeration.RpcErrorMessageEnum;
import com.planning.rpc.enumeration.RpcResponseCode;
import com.planning.rpc.exception.RpcException;

import java.util.Objects;

/**
 * @author yxc
 * @since 2020-10-15 10:35
 **/
public final class RpcMessageCheck {

    private static final String INTERFACE_NAME = "interfaceName";

    private RpcMessageCheck(){

    }

    public static void check(RpcResponse rpcResponse, RpcRequest rpcRequest){
        if(Objects.isNull(rpcResponse)){
            throw new RpcException(RpcErrorMessageEnum.SERVICE_INVOCATION_FAILURE, INTERFACE_NAME + ":" + rpcRequest.getInterfaceName());
        }

        if(!Objects.equals(rpcRequest.getRequestId(), rpcResponse.getRequestId())){
            throw new RpcException(RpcErrorMessageEnum.REQUEST_NOT_MATCH_RESPONSE, INTERFACE_NAME + ":" + rpcRequest.getInterfaceName());
        }

        if(Objects.isNull(rpcResponse.getCode()) || Objects.equals(rpcResponse.getCode(), RpcResponseCode.SUCCESS.getCode())){
            throw new RpcException(RpcErrorMessageEnum.SERVICE_INVOCATION_FAILURE, INTERFACE_NAME + ":" + rpcRequest.getInterfaceName());
        }
    }

}