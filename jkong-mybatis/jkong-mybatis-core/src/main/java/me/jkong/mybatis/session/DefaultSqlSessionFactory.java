package me.jkong.mybatis.session;

/**
 * {@link SqlSessionFactory} 默认实现类，用来创建 {@link SqlSession}
 *
 * @author JKong
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 创建 SQLSession 对象
     *
     * @return sqlSession
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}