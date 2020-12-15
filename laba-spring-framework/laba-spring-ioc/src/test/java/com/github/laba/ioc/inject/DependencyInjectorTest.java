package com.github.laba.ioc.inject;

import com.github.laba.ioc.core.BeanContainer;
import com.github.laba.ioc.frame.controller.frontend.MainPageController;
import com.github.laba.ioc.frame.service.HeadLineShopCategoryCombineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 依赖注入器测试
 *
 * @author laba zhang
 */
class DependencyInjectorTest {
    @Test
    @DisplayName("测试依赖注入")
    void doIocTest() {
        BeanContainer container = BeanContainer.getInstance();
        container.loadBeans("com.github.laba.ioc.frame");
        Assertions.assertTrue(container.isLoaded());
        MainPageController mainPageController = (MainPageController) container.getBean(MainPageController.class);
        Assertions.assertTrue(mainPageController instanceof MainPageController);
        HeadLineShopCategoryCombineService combineService = mainPageController.getCombineService();
        Assertions.assertNull(combineService);
        new DependencyInjector().doIoc();
        Assertions.assertNotEquals(null,mainPageController.getCombineService());
        Assertions.assertTrue(mainPageController.getCombineService() instanceof HeadLineShopCategoryCombineService);
    }
}