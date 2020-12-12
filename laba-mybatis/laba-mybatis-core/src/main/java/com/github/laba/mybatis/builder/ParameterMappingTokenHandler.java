package com.github.laba.mybatis.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 此Handler主要解决SQL中占位符的参数问题
 *
 * @author JKong
 * @version v0.0.1
 * @date 2020/6/16 11:24.
 */
public class ParameterMappingTokenHandler implements TokenHandler {
    private List<ParameterMapping> parameterMappings = new ArrayList<>();

    /**
     * context是参数名称 #{id} #{username}
     *
     * @param content sql
     * @return 将sql中的的站位参数替换为'?'
     */
    @Override
    public String handleToken(String content) {
        parameterMappings.add(buildParameterMapping(content));
        return "?";
    }

    private ParameterMapping buildParameterMapping(String content) {
        return new ParameterMapping(content);
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public void setParameterMappings(List<ParameterMapping> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }
}