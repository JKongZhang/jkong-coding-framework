package com.github.laba.mvc.annotation;

import java.lang.annotation.*;

/**
 * RequestMapping Annotation
 *
 * @author laba zhang
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface LabaRequestMapping {
    String value() default "";
}
