package com.planning.rpc.core.config;

import com.planning.rpc.utils.concurrent.threadpool.ThreadPoolFactoryUtils;
import com.planning.rpc.utils.zk.CuratorUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 当服务端 provider 关闭的时候，做一些事情 比如取消注册所有服务
 * @author yxc
 * @since 2020-10-15 17:28
 **/
@Slf4j
public class CustomShutdownHook {

    private static final CustomShutdownHook CUSTOM_SHUTDOWN_HOOK = new CustomShutdownHook();

    public static CustomShutdownHook getCustomShutdownHook(){
        return CUSTOM_SHUTDOWN_HOOK;
    }

    public void clearAll(){
        log.info("addShutdownHook for clearAll...");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            CuratorUtils.clearRegistry();
            ThreadPoolFactoryUtils.shutDownAllThreadPool();
        }));
    }
}