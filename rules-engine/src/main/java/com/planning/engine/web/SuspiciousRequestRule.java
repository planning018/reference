package com.planning.engine.web;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yxc
 * @date 2021/3/1 17:03
 */
public class SuspiciousRequestRule {

    static final String SUSPICIOUS = "suspicious";

    @Condition
    public boolean isSuspicious(@Fact("request") HttpServletRequest request){
        // criteria of suspicious could be based on ip, user-agent. etc.
        // here for simplicity, it is based on the presence of a request parameter 'suspicious'
        return request.getParameter(SUSPICIOUS) != null;
    }

    @Action
    public void setSuspicious(@Fact("request") HttpServletRequest request){
        request.setAttribute(SUSPICIOUS, true);
    }
}
