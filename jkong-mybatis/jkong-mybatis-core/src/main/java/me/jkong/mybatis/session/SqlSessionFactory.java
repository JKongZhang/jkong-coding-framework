package me.jkong.mybatis.session;

public interface SqlSessionFactory {
    public SqlSession openSession();
}