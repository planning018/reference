package com.planning.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * log4j 的简单用法
 */
public class LogDemo {

    private static Logger logger = LoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args) {
        logger.info("logger begin....");
        logger.info("logger end.....");
    }
}
