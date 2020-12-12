package com.github.laba.mybatis.session;

import com.github.laba.mybatis.builder.XMLConfigBuilder;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * {@link SqlSessionFactory} 建造者
 *
 * @author JKong
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) throws DocumentException, PropertyVetoException {
        // 1. 使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();

        // 2. 解析配置文件，将配置信息封装为 Configuration 对象
        Configuration configuration = xmlConfigBuilder.parseConfig(in);

        // 3. 通过 Configuration 创建 sqlSessionFactory 默认实现类 DefaultSqlSessionFactory 对象
        return new DefaultSqlSessionFactory(configuration);
    }
}