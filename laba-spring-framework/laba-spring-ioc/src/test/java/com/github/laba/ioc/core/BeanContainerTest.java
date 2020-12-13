package com.github.laba.ioc.core;

import com.github.laba.ioc.core.annotation.Component;
import com.github.laba.ioc.core.annotation.Controller;
import com.github.laba.ioc.core.annotation.Repository;
import com.github.laba.ioc.core.annotation.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 测试 BeanContainer
 *
 * @author laba zhang
 */
class BeanContainerTest {
    private BeanContainer container;

    @BeforeEach
    void setUp() {
        container = BeanContainer.getInstance();
    }

    @Test
    void loadBeans() {
        Assertions.assertFalse(container.isLoaded());
        container.loadBeans("com.github.laba.ioc.core");
        Assertions.assertTrue(container.isLoaded());
        Assertions.assertEquals(4, container.size());
    }

    @Component
    public static class TestClass1 {

    }

    @Controller
    public static class TestClass2 {

    }

    @Service
    public static class TestClass3 {

    }

    @Repository
    public static class TestClass4 {

    }

    public static class TestClass {

    }
}