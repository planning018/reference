package com.planning.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author yxc
 * @since 2020-10-15 10:18
 **/
@AllArgsConstructor
@Getter
@ToString
public enum RpcResponseCode {

    /**
     * SUCCESS
     */
    SUCCESS(200, "调用方法成功"),
    /**
     * FAIL
     */
    FAIL(500, "调用方法失败"),
    /**
     * NOT_FOUND_METHOD
     */
    NOT_FOUND_METHOD(500, "未找到指定方法"),
    /**
     * NOT_FOUND_CLASS
     */
    NOT_FOUND_CLASS(500, "未找到指定类");

    private final int code;
    private final String message;
}