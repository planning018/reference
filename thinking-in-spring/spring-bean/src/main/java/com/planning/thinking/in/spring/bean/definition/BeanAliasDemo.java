package com.planning.thinking.in.spring.bean.definition;

import com.planning.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 * @author yxc
 * @date 2020-12-24 11:04
 **/
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 XML 文件，启动 Spring 上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("/META-INF/bean-definitions-context.xml");
        // 通过别名获取曾用名 commonUser 的 planningUser
        User commonUser = beanFactory.getBean("commonUser", User.class);
        User planningUser = beanFactory.getBean("planningUser", User.class);
        System.out.println("commonUser 与 planningUser 是否相同：" + (commonUser == planningUser));
    }
}