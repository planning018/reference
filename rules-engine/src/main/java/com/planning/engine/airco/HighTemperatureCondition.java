package com.planning.engine.airco;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;

/**
 * @author yxc
 * @date 2021/3/1 16:43
 */
public class HighTemperatureCondition implements Condition {

    static HighTemperatureCondition itIsHot(){
        return new HighTemperatureCondition();
    }

    @Override
    public boolean evaluate(Facts facts) {
        Integer temperature = facts.get("temperature");
        return temperature > 25;
    }
}
