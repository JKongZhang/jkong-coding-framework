package com.github.laba.ioc.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * 处理Class相关的操作
 *
 * @author laba zhang
 */
@Slf4j
public class ClassUtil {

    private static final String FILE_PROTOCOL = "file";

    /**
     * 根据包名获取包路径下的 Class 对象
     *
     * @param packageName 包名
     * @return 此包路径下的所有的 Class 对象
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        if (packageName == null) {
            throw new NullPointerException("package name must not null.");
        }
        // 1. 获取类加载器
        ClassLoader loader = getClassLoader();
        // 2. 使用类加载器加载指定包路径下的资源
        URL url = loader.getResource(packageName.replace(".", "/"));
        if (url == null) {
            log.warn("unable to retrieve any file from package: {}", packageName);
            return new HashSet<>();
        }
        // 根据不同的资源类型，采用不同的方式获取类资源
        Set<Class<?>> classSet = null;
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<>();
            File fileDirectory = new File(url.getPath());
            extractClassFile(fileDirectory, classSet, packageName);
        } else {
            // todo: 如果目录下存在jar包，同样解析jar包中的文件
        }
        return classSet;
    }

    /**
     * 根据文件目录，使用递归方式获取文件下可识别的类
     *
     * @param fileDirectory 文件目录
     * @param classSet      解析出的class的集合
     * @param packageName   类包名
     */
    public static void extractClassFile(File fileDirectory, Set<Class<?>> classSet, String packageName) {
        // 如果非目录则返回
        if (!fileDirectory.isDirectory()) {
            return;
        }

        File[] dirs = fileDirectory.listFiles(new FileFilter() {
            private static final String CLASS_SUFFIX = ".class";

            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    String fileAbsolutePath = file.getAbsolutePath();
                    if (fileAbsolutePath.endsWith(CLASS_SUFFIX)) {
                        addToClassSet(fileAbsolutePath);
                    }
                }
                return false;
            }

            /**
             * 将获取的文件天交到 classSet 中
             *
             * @param absolutePath 获取到的class文件
             */
            private void addToClassSet(String absolutePath) {
                // 从文件路径中截取出包名, 先将文件路径分隔符替换为‘.’
                absolutePath = absolutePath.replace(File.separator, ".");
                // 获取className
                String className = absolutePath.substring(absolutePath.indexOf(packageName));
                // 去掉 .class 后缀
                className = className.substring(0, className.lastIndexOf("."));
                Class<?> loadClass = loadClass(className);
                if (loadClass != null) {
                    classSet.add(loadClass);
                }
            }
        });

        // 将获取的目录继续递归
        if (dirs != null) {
            for (File dir : dirs) {
                extractClassFile(dir, classSet, packageName);
            }
        }
    }

    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("class named {} not found.", className);
            return null;
        }
    }

    /**
     * 获取当前线程上下文的类加载器
     *
     * @return 类加载器
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 实例化Class对象
     *
     * @param aClass     clazz
     * @param accessible 是否支持通过是有构造器创建Class对象实例
     * @param <T>        Class 类型
     * @return 实例化的对象
     */
    public static <T> T newInstance(Class<?> aClass, boolean accessible) {
        try {
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(accessible);
            return (T) declaredConstructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            log.error("instance error,", e);
            throw new RuntimeException(e);
        }
    }
}
