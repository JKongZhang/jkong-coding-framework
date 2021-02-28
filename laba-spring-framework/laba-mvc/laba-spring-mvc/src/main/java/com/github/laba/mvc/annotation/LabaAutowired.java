package com.github.laba.mvc.annotation;

import java.lang.annotation.*;

/**
 * Autowired Annotation
 *
 * @author laba zhang
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface LabaAutowired {
}
