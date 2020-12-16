package com.planning.thinking.in.spring.ioc.overview.dependency.injection;

import com.planning.thinking.in.spring.ioc.overview.repository.UserReponsitory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 *
 * @author yxc
 * @since 2020-12-16 19:57
 **/
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        // 配置 XML 文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject-context.xml");

        // 启动 Spring 上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject-context.xml");

        UserReponsitory userReponsitory = applicationContext.getBean("userRepository", UserReponsitory.class);



    }
}