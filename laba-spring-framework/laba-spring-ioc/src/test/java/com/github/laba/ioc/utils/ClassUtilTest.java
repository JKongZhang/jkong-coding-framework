package com.github.laba.ioc.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * ClassUtil 测试类
 *
 * @author laba zhang
 */
class ClassUtilTest {

    @DisplayName("提取指定包下的class：extractPackageClassTest ")
    @Test
    void extractPackageClassTest() {
        Set<Class<?>> classes = ClassUtil.extractPackageClass("com.github.laba.ioc");
        Assertions.assertNotNull(classes);
        Assertions.assertEquals(1, classes.size());
        classes = ClassUtil.extractPackageClass("com.github.laba.ioc.empty");
        Assertions.assertEquals(0, classes.size());
    }

    public static void main(String[] args) {
        new ClassUtilTest().extractPackageClassTest();
    }
}