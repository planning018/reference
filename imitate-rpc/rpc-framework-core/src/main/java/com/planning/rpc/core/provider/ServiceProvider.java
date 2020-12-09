package com.planning.rpc.core.provider;

/**
 * 保存和提供服务实例对象，客户端使用
 *
 * @author xingcheng.yin
 */
public interface ServiceProvider {

    /**
     * 保存服务实例对象 和 实例对象实现接口类的对应关系
     *
     * @param service
     * @param serviceClass
     * @param <T>
     */
    <T> void addServiceProvider(T service, Class<T> serviceClass);

    /**
     * 获取服务实例对象
     *
     * @param serviceName
     * @return
     */
    Object getServiceProvider(String serviceName);
}
