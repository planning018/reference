package com.planning.engine.shop;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author yxc
 * @date 2021/3/1 16:02
 */
public class Launcher {

    public static void main(String[] args) throws Exception {
        // create a person instance (fact)
        Person tom = new Person("Tom", 14);
        Facts facts = new Facts();
        facts.put("person", tom);

        // creates rules
        MVELRule ageRule = new MVELRule()
                .name("age rule")
                .description("check if person's age > 18 and mark the person as adult")
                .priority(1)
                .when("person.age > 18")
                .then("person.setAdult(true)");
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        String fileName = args.length != 0 ? args[0] : "F:\\MyWorkSpace\\Github\\reference\\rules-engine\\src\\main\\java\\com\\planning\\engine\\shop\\alcohol-rule.yml";

        Rule alcoholRules = ruleFactory.createRule(new FileReader(fileName));

        // create a rule set
        Rules rules = new Rules();
        rules.register(ageRule);
        rules.register(alcoholRules);

        // create a default rules engine and fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();

        System.out.println("Tom: Hi! Can I have some Vodka please?");
        rulesEngine.fire(rules, facts);
    }
}
