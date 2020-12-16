package com.planning.thinking.in.spring.ioc.overview.dependency.lookup;

import com.planning.thinking.in.spring.ioc.overview.annotation.Super;
import com.planning.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 *
 * @author yxc
 * @since 2020-12-10 10:19
 **/
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");
        // 按照类型查找
        lookupByType(beanFactory);
        // 按照类型查找，结合对象
        lookupCollectionByType(beanFactory);
        // 通过注解查找
        lookupByAnnotationType(beanFactory);

        lookupInLazy(beanFactory);
        lookupInRealTime(beanFactory);

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + userMap);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User commonUser = beanFactory.getBean(User.class);
        System.out.println("实时查找：" + commonUser);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 的所有的 User 集合对象：" + users);
        }
    }

    private static void lookupInLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("commonUser");
        System.out.println("实时查找：" + user);
    }

}