package com.github.laba.mybatis.session;

/**
 * @author laba zhang
 */
public interface SqlSessionFactory {
    /**
     * 获取 SQLSession对象，通过 SQLSession对象实现对执行SQL的处理。
     *
     * @return SqlSession
     */
    public SqlSession openSession();
}