package com.github.laba.ioc.core;

import com.github.laba.ioc.core.annotation.Component;
import com.github.laba.ioc.core.annotation.Controller;
import com.github.laba.ioc.core.annotation.Repository;
import com.github.laba.ioc.core.annotation.Service;
import org.junit.jupiter.api.*;

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
        container.loadBeans("com.github.laba.ioc.core");
    }

    @Test
    void loadBeans() {
        Assertions.assertTrue(container.isLoaded());
        Assertions.assertEquals(4, container.size());
    }


    @Test
    @Order(2)
    @DisplayName("根据类获取实例：getBeanTest")
    public void getBeansTest() {
        TestClass1 testClass1 = container.getBean(TestClass1.class);
        Assertions.assertTrue(testClass1 instanceof TestClass1);
    }

    @Test
    @Order(3)
    @DisplayName("根据注解获取实例")
    public void getClassByAnnotationTest() {
        Assertions.assertTrue(container.isLoaded());
        Assertions.assertEquals(1, container.getClassesByAnnotation(Controller.class).size());
    }

    @Test
    @DisplayName("根据接口获取实例")
    @Order(4)
    public void getClassBySuperClass() {
        Assertions.assertTrue(container.isLoaded());
        Assertions.assertTrue(container.getClassesBySuper(TestClass3.class).contains(TestClass4.class));
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
    public static class TestClass4 extends TestClass3 {

    }

    public static class TestClass {

    }
}