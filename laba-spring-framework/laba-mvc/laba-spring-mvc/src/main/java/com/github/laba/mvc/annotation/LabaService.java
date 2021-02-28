package com.github.laba.mvc.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Service Annotation
 *
 * @author laba zhang
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface LabaService {
    String value() default "";
}
