package me.jkong.mybatis.executor;

import me.jkong.mybatis.builder.MappedStatement;
import me.jkong.mybatis.session.Configuration;

import java.sql.SQLException;
import java.util.List;

public interface Executor {
    <E> List<E> query(Configuration configuration, MappedStatement
            mappedStatement, Object[] param) throws Exception;

    void close() throws SQLException;
}