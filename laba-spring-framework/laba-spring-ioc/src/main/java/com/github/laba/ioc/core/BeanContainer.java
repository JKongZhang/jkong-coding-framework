package com.github.laba.ioc.core;

import com.github.laba.ioc.core.annotation.Component;
import com.github.laba.ioc.core.annotation.Controller;
import com.github.laba.ioc.core.annotation.Repository;
import com.github.laba.ioc.core.annotation.Service;
import com.github.laba.ioc.utils.ClassUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean 单例 容器
 *
 * @author laba zhang
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {
    /**
     * Bean 容器
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();
    /**
     * 当类被以下注解修饰时，就加载到容器中，管理起来
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION =
            Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);

    /**
     * 实例化Bean的数量
     *
     * @return 实例化bean的数量
     */
    public int size() {
        return beanMap.size();
    }

    private enum ContainerHolder {
        /**
         * Bean Container 枚举
         */
        HOLDER;
        private final BeanContainer container;

        ContainerHolder() {
            container = new BeanContainer();
        }
    }

    @Getter
    private boolean loaded = false;

    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.container;
    }

    /**
     * 指定包路径加载类Class对象，并实例化添加到BeanMap中
     *
     * @param packageName 包路径
     */
    public synchronized void loadBeans(String packageName) {
        // 已经加载，则不需要再次加载。todo：需要对不同packageName进行区分，使用ConcurrentHashMap保存加载过的PackageName，并设置状态为true
        if (isLoaded()) {
            log.info("Beans have been loaded!");
        }

        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (classSet == null || classSet.size() == 0) {
            log.warn("extract nothing from package: {}", packageName);
            return;
        }

        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                if (clazz.isAnnotationPresent(annotation)) {
                    // 实例化 bean，并添加到Bean Map中 todo:需要解决支持多参数构造器，并解决循环依赖问题
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }

    /**
     * 增加一个实例
     *
     * @param clazz Class 对象
     * @param bean  Class 对应的实例
     * @return 如果已经存在，则返回旧的实例，否则为null
     */
    public <T> T addBean(Class<T> clazz, Object bean) {
        Object o = beanMap.put(clazz, bean);
        if (o == null) {
            return null;
        }
        return (T) o;
    }

    /**
     * 根据 Class 对象，移除对应实例
     *
     * @param clazz Class 对象
     * @return 如果此 Class 对象存在对应事例，那么则返回，否则返回null
     */
    public <T> T remove(Class<T> clazz) {
        Object o = beanMap.remove(clazz);
        if (o == null) {
            return null;
        }
        return (T) o;
    }

    /**
     * 类获取实例
     *
     * @param clazz Class 对象
     * @return Class 对应实例对象
     */
    public <T> T getBean(Class<T> clazz) {
        Object o = beanMap.get(clazz);
        if (o == null) {
            return null;
        }
        return (T) o;
    }

    /**
     * 获取所有的 bean class 集合
     *
     * @return bean class 集合
     */
    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }

    /**
     * 获取所有实例
     *
     * @return 所有容器管理的 bean对象
     */
    public Set<Object> getBeans() {
        return new HashSet<>(beanMap.values());
    }
}
