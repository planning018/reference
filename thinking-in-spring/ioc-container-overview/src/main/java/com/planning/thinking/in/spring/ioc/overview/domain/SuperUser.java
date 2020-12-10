package com.planning.thinking.in.spring.ioc.overview.domain;

/**
 * 超级用户 - 测试
 *
 * @author yxc
 * @since 2020-12-10 10:36
 **/
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}