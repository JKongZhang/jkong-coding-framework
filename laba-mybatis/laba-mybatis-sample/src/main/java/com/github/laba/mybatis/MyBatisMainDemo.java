package com.github.laba.mybatis;

import com.github.laba.mybatis.io.Resources;
import com.github.laba.mybatis.dao.IUserDao;
import com.github.laba.mybatis.entity.User;
import com.github.laba.mybatis.session.SqlSession;
import com.github.laba.mybatis.session.SqlSessionFactory;
import com.github.laba.mybatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 测试laba MyBatis 整体流程
 *
 * @author laba zhang
 * @version v0.0.1
 * @date 2020/6/17 16:04.
 */
public class MyBatisMainDemo {

    public static void main(String[] args) throws Exception {

        // 框架入口：指定文件路径，加载配置信息
        InputStream resourceAsSteam = Resources.getResourceAsSteam("/laba-mybatis-config.xml");
        // 创建Sql工厂：SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        // 获取用来执行SQL操作的 SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取 Mapper 对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 查询所有记录
        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }

        // 使用同一个SqlSession，再查询一条数据
        User user = new User();
        user.setId(1L);
        user.setUsername("laba");
        System.out.println(userDao.selectOne(user));
    }

}