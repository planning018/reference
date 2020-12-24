package com.planning.thinking.in.spring.bean.factory;

import com.planning.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link User} User 工厂类
 *
 * @author yxc
 * @date 2020-12-24 11:05
 **/
public interface UserFactory {

    /**
     * 新增 User
     * @return User
     */
    default User createUser(){
        return User.createUser();
    }
}