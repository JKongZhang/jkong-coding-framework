package com.github.laba.ioc.inject.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * autowired 依赖注入
 *
 * @author laba zhang
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {

    /**
     * 指定默认注入的类名
     */
    String value() default "";
}
