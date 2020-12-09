package com.planning.study.rpc.test;

/**
 * HelloServiceImpl
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
