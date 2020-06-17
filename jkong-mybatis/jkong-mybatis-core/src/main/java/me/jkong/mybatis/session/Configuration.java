package me.jkong.mybatis.session;

import me.jkong.mybatis.builder.MappedStatement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * jkong-mybatis 核心配置类
 *
 * @author JKong
 */
public class Configuration {

    /**
     * 数据源
     */
    private DataSource dataSource;

    /**
     * map集合
     * key:statementId
     * value:MappedStatement
     */
    private Map<String, MappedStatement> mappedStatementMap = new HashMap<String, MappedStatement>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}