package com.planning.thinking.in.spring.ioc.overview.domain;

/**
 * 用户类
 *
 * @author yxc
 * @since 2020-12-10 10:21
 **/
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("planning");
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}