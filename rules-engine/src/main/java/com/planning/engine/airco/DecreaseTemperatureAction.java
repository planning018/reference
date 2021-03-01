package com.planning.engine.airco;


import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Facts;

/**
 * @author yxc
 * @date 2021/3/1 16:40
 */
public class DecreaseTemperatureAction implements Action {

    static DecreaseTemperatureAction decreaseTemperatureAction(){
        return new DecreaseTemperatureAction();
    }

    @Override
    public void execute(Facts facts) throws Exception {
        System.out.println("It is hot! cooling air...");
        Integer temperature = facts.get("temperature");
        facts.put("temperature", temperature - 1);
    }
}
