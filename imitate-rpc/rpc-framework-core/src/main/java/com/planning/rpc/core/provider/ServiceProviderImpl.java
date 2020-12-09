package com.planning.rpc.core.provider;

import com.planning.rpc.enumeration.RpcErrorMessageEnum;
import com.planning.rpc.exception.RpcException;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yxc
 * @since 2020-10-15 11:21
 **/
@Slf4j
public class ServiceProviderImpl implements ServiceProvider {

    private static Map<String, Object> serviceMap = new ConcurrentHashMap<>();
    private static Set<String> registeredService = ConcurrentHashMap.newKeySet();

    @Override
    public <T> void addServiceProvider(T service, Class<T> serviceClass) {
        String serviceName = serviceClass.getCanonicalName();
        if (registeredService.contains(serviceName)) {
            return;
        }
        serviceMap.put(serviceName, service);
        registeredService.add(serviceName);
        log.info("Add service: {}, Interface is {}", serviceName, service.getClass().getInterfaces());
    }

    @Override
    public Object getServiceProvider(String serviceName) {
        Object service = serviceMap.get(serviceName);
        if (Objects.isNull(service)) {
            throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND);
        }
        return service;
    }
}