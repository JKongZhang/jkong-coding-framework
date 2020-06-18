package me.jkong.mybatis.io;

import java.io.InputStream;

/**
 * XML文本数据读取类
 *
 * @author JKong
 */
public class Resources {

    /**
     * 通过 {@link Class#getResourceAsStream(String)} 获取指定路径的资源
     *
     * @param path 文件路径
     *             根据路下文件：/
     * @return
     */
    public static InputStream getResourceAsSteam(String path) {
        return Resources.class.getResourceAsStream(path);
    }
}