package com.planning.rpc.core.remoting.dto;

import com.planning.rpc.enumeration.RpcResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author yxc
 * @since 2020-10-15 10:11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RpcResponse<T> implements Serializable {

    private String requestId;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    public static <T> RpcResponse<T> success(String requestId, T data){
        RpcResponse<T> response = new RpcResponse<>();
        response.setRequestId(requestId);
        response.setCode(RpcResponseCode.SUCCESS.getCode());
        response.setMessage(RpcResponseCode.SUCCESS.getMessage());
        if(Objects.nonNull(data)){
            response.setData(data);
        }
        return response;
    }

    public static <T> RpcResponse<T> fail(RpcResponseCode rpcResponseCode){
        RpcResponse<T> rpcResponse = new RpcResponse<>();
        rpcResponse.setCode(rpcResponseCode.getCode());
        rpcResponse.setMessage(rpcResponse.getMessage());
        return rpcResponse;
    }
}