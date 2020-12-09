package com.planning.rpc;

import com.planning.rpc.utils.zk.CuratorUtils;
import org.junit.Test;

/**
 * @author yxc
 * @since 2020-10-14 16:48
 **/
public class ZkTest {

    @Test
    public void zkCreateNodeTest(){
        String serviceName = "com.planning.rpc.HelloService/127.0.0.1:9999";
        CuratorUtils.createPersistentNode(CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + serviceName);
    }

    @Test
    public void zkReadNodeTest(){
        String serviceName = "com.planning.rpc.HelloService";
        String serviceAddress = CuratorUtils.getChildrenNodes(serviceName).get(0);
        System.out.println("服务器地址是：" + serviceAddress);
    }
}