package com.planning.rpc.core.registry;

import com.planning.rpc.utils.zk.CuratorUtils;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

/**
 * @author yxc
 * @since 2020-10-14 19:34
 **/
@Slf4j
public class ZkServiceDiscovery implements ServiceDiscovery {
    @Override
    public InetSocketAddress lookupService(String serviceName) {
        // ptodo 此处可做负载均衡，这里简单处理，取第一个值
        String serviceAddress = CuratorUtils.getChildrenNodes(serviceName).get(0);
        log.info("成功找到服务地址：{}", serviceAddress);
        List<String> addressInfo = Arrays.asList(serviceAddress.split(":"));
        return new InetSocketAddress(addressInfo.get(0), Integer.valueOf(addressInfo.get(1)));
    }
}