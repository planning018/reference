package com.planning.engine.helloworld;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

/**
 * @author yxc
 * @date 2021/3/1 15:28
 */
@Rule(name = "Hello World Rule", description = "Always say hello world")
public class HelloWorldRule {

    @Condition
    public boolean when(){
        return true;
    }

    @Action
    public void then(){
        System.out.println("hello world");
    }
}
