package com.github.laba.mvc.servlet;

import org.springframework.lang.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * LabaDispatcherServlet 辅助处理类
 *
 * @author laba zhang
 */
public class LabaDispatcherServletSupport {

    private static final Properties CONTEXT_CONFIG = new Properties();

    public static void doLoadContextConfig(@NonNull String contextLocation) {
        InputStream resourceAsStream = LabaDispatcherServletSupport.class
                .getClassLoader().getResourceAsStream(contextLocation);
        try {
            CONTEXT_CONFIG.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConfig(String key) {
        return CONTEXT_CONFIG.getProperty(key);
    }

    public static String getConfig(String key, String defaultValue) {
        return CONTEXT_CONFIG.getProperty(key, defaultValue);
    }
}
