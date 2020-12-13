package com.github.laba.ioc.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 判空工具
 *
 * @author zhdh
 */
public class ValidationUtil {
    /**
     * 集合判空
     */
    public static boolean isEmpty(Collection<?> obj) {
        return obj == null || obj.isEmpty();
    }

    /**
     * 字符串判空
     */
    public static boolean isEmpty(String obj) {
        return obj == null || "".equals(obj);
    }

    /**
     * 数组判空
     */
    public static boolean isEmpty(Object[] obj) {
        return obj == null || obj.length == 0;
    }

    /**
     * 图判空
     */
    public static boolean isEmpty(Map<?, ?> obj) {
        return obj == null || obj.isEmpty();
    }
}