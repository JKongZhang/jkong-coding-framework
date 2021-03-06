package com.github.laba.mybatis.builder;

/**
 * mapper xml 配置文件的 SQL 配置的映射类
 * 每一个 MappedStatement 对象，对应一条 SQL 配置
 *
 * @author laba zhang
 */
public class MappedStatement {
    /**
     * id标识
     */
    private String id;
    /**
     * 返回值类型
     */
    private String resultType;
    /**
     * 参数值类型
     */
    private String parameterType;
    /**
     * sql语句
     */
    private String sql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}