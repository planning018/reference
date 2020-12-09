package com.planning.rpc.core.registry;

import com.planning.rpc.utils.zk.CuratorUtils;

import java.net.InetSocketAddress;

/**
 * @author yxc
 * @since 2020-10-14 19:28
 **/
public class ZkServiceRegistry implements ServiceRegistry {

    @Override
    public void registerService(String serviceName, InetSocketAddress inetSocketAddress) {
        // 根节点下注册子节点：服务
        String servicePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + serviceName + inetSocketAddress.toString();
        CuratorUtils.createPersistentNode(servicePath);
    }
}