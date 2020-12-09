package com.planning.rpc.core;

import com.planning.rpc.core.registry.ServiceDiscovery;
import com.planning.rpc.core.registry.ServiceRegistry;
import com.planning.rpc.core.registry.ZkServiceDiscovery;
import com.planning.rpc.core.registry.ZkServiceRegistry;
import com.planning.rpc.core.remoting.dto.RpcRequest;
import org.junit.Test;

import java.net.InetSocketAddress;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author yxc
 * @since 2020-10-14 19:41
 **/
public class zkCoreTest {

    @Test
    public void should_register_service_successful_and_lookup_service_by_service_name(){
        ServiceRegistry serviceRegistry = new ZkServiceRegistry();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 2181);
        serviceRegistry.registerService("com.planning.rpc.BookService", inetSocketAddress);

        ServiceDiscovery serviceDiscovery = new ZkServiceDiscovery();
        InetSocketAddress acquireAddress = serviceDiscovery.lookupService("com.planning.rpc.BookService");
        assertEquals(inetSocketAddress.toString(), acquireAddress.toString());
    }

    @Test
    public void testLombokToString(){
        RpcRequest request = new RpcRequest("123","abc","test",null,null);
        System.out.println(request.toString());
    }
}