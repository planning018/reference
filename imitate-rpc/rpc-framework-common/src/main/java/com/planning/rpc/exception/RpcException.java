package com.planning.rpc.exception;

import com.planning.rpc.enumeration.RpcErrorMessageEnum;

/**
 * @author yxc
 * @since 2020-10-14 16:23
 **/
public class RpcException extends RuntimeException {

    public RpcException(RpcErrorMessageEnum rpcErrorMessageEnum, String detail){
        super(rpcErrorMessageEnum.getMessage() + ":" + detail);
    }

    public RpcException(RpcErrorMessageEnum rpcErrorMessageEnum){
        super(rpcErrorMessageEnum.getMessage());
    }

    public RpcException(String message, Throwable cause){
        super(message, cause);
    }
}