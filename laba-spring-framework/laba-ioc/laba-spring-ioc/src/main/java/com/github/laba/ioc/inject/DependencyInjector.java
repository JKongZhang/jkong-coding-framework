package com.github.laba.ioc.inject;

import com.github.laba.ioc.core.BeanContainer;
import com.github.laba.ioc.inject.annotation.Autowired;
import com.github.laba.ioc.utils.ClassUtil;
import com.github.laba.ioc.utils.ValidationUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * 依赖注入器
 *
 * @author laba zhang
 */
@Slf4j
public class DependencyInjector {

    /**
     * Bean container
     */
    private final BeanContainer beanContainer;

    public DependencyInjector() {
        this.beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行依赖注入
     */
    public void doIoc() {
        // 1. 遍历容器
        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("bean container has no one bean.");
            return;
        }

        for (Class<?> clazz : beanContainer.getClasses()) {
            // 遍历每个对象的成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }
            // 找到自动注入的注解
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String autowiredValue = autowired.value();
                    // 获取类型
                    Class<?> fieldClass = field.getType();
                    // 容器中找到
                    Object fieldValue = getFiledInstance(fieldClass, autowiredValue);
                    if (fieldValue == null) {
                        throw new RuntimeException("failed to injected, bean container do not find this class object: " + autowiredValue);
                    } else {
                        // 注入
                        Object targetBean = beanContainer.getBean(clazz);
                        // 通过反射注入
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }
                }
            }
        }
    }

    /**
     * 根据class对象 获取容器管理的类或者实现类
     *
     * @param fieldClass     属性 Class
     * @param autowiredValue autowired value 设置的默认注入类对象
     * @return 属性类实例
     */
    private Object getFiledInstance(Class<?> fieldClass, String autowiredValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        //入如果直接获取到了就返回
        if (fieldValue != null) {
            return fieldValue;
        } else {
            //找实现类
            Class<?> implClass = getImplementClass(fieldClass, autowiredValue);
            if (implClass != null) {
                return beanContainer.getBean(implClass);
            } else {
                return null;
            }
        }
    }

    /**
     * 获取接口的实现类
     *
     * @param fieldClass     需要被注入属性Class
     * @param autowiredValue autowired value 设置的默认注入类对象
     * @return 属性实现类Class对象
     */
    private Class<?> getImplementClass(Class<?> fieldClass, String autowiredValue) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (!ValidationUtil.isEmpty(classSet)) {
            // 如果有多个实现类，spring 中通过 Qualifier 设置名称，本framework 使用autowired#value设置
            if (ValidationUtil.isEmpty(autowiredValue)) {
                // 说明没有精确指定
                if (classSet.size() == 1) {
                    return classSet.iterator().next();
                } else {
                    // 抛出异常
                    throw new RuntimeException("multiple implemented classes for " + fieldClass.getName() + ", please set default implemented class for this.");
                }
            } else {
                for (Class<?> clazz : classSet) {
                    //如果类的类名等于指定的名字
                    if (autowiredValue.equals(clazz.getSimpleName())) {
                        return clazz;
                    }
                }
            }
        }
        return null;
    }
}
