package me.jkong.mybatis.io;

import java.io.InputStream;

/**
 * XML文本数据读取类
 *
 * @author JKong
 */
public class Resources {
    public static InputStream getResourceAsSteam(String path) {
        return Resources.class.getResourceAsStream(path);
    }
}