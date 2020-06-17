package me.jkong.mybatis.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author JKong
 * @version v0.0.1
 * @date 2020/6/16 11:24.
 */
public class ParameterMappingTokenHandler implements TokenHandler {
    private List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();

    /**
     * context是参数名称 #{id} #{username}
     *
     * @param content
     * @return
     */
    @Override
    public String handleToken(String content) {
        parameterMappings.add(buildParameterMapping(content));
        return "?";
    }

    private ParameterMapping buildParameterMapping(String content) {
        ParameterMapping parameterMapping = new ParameterMapping(content);
        return parameterMapping;
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public void setParameterMappings(List<ParameterMapping> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }
}