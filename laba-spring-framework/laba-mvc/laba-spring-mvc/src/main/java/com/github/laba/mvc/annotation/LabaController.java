package com.github.laba.mvc.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Controller Annotation
 *
 * @author laba zhang
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface LabaController {
    String value() default "";
}
