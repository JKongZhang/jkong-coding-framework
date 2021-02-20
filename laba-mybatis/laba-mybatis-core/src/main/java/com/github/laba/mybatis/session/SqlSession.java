package com.github.laba.mybatis.session;

import com.github.laba.mybatis.builder.MappedStatement;

import java.util.List;

public interface SqlSession {
    /**
     * 查询所有
     *
     * @param statementId mapper 中配置的 SQL 唯一标识 {@link MappedStatement#getId()}
     * @param params      sql 需要的参数
     * @param <E>         返回体泛型
     * @return 查询结果
     * @throws Exception e
     */
    <E> List<E> selectList(String statementId, Object... params) throws Exception;

    /**
     * 根据条件查询单个
     *
     * @param statementId mapper 中配置的 SQL 唯一标识 {@link MappedStatement#getId()}
     * @param params      sql 需要的参数
     * @param <T>         返回体泛型
     * @return 查询结果
     * @throws Exception e
     */
    <T> T selectOne(String statementId, Object... params) throws Exception;

    /**
     * 为Dao接口生成代理实现类
     *
     * @param mapperClass 定义的mapper class
     * @param <T>         泛型
     * @return t
     */
    <T> T getMapper(Class<?> mapperClass);
}