package com.planning.study.rpc.test;

import com.planning.study.rpc.framework.RpcFramework;

import java.io.IOException;

/**
 * RpcProvider
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
