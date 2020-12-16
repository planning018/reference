package com.planning.thinking.in.spring.ioc.overview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * super user
 *
 * @author xingcheng.yin
 * @date 2020.12.16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
