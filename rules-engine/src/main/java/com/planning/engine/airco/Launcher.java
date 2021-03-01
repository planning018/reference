package com.planning.engine.airco;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.InferenceRulesEngine;
import org.jeasy.rules.core.RuleBuilder;

import static com.planning.engine.airco.DecreaseTemperatureAction.decreaseTemperatureAction;
import static com.planning.engine.airco.HighTemperatureCondition.itIsHot;

/**
 * @author yxc
 * @date 2021/3/1 16:44
 */
public class Launcher {

    public static void main(String[] args) {
        // define facts
        Facts facts = new Facts();
        facts.put("temperature", 30);

        // define rules
        Rule airConditionRule = new RuleBuilder()
                .name("air condition rule")
                .when(itIsHot())
                .then(decreaseTemperatureAction())
                .build();
        Rules rules = new Rules();
        rules.register(airConditionRule);

        // fire rules on known facts
        RulesEngine rulesEngine = new InferenceRulesEngine();
        rulesEngine.fire(rules, facts);
    }

}
