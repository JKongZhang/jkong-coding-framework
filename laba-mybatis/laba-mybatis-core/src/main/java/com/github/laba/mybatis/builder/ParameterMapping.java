package com.github.laba.mybatis.builder;

/**
 * sql 请求参数实体
 *
 * @author laba zhang
 */
public class ParameterMapping {

    private String content;

    public ParameterMapping(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
