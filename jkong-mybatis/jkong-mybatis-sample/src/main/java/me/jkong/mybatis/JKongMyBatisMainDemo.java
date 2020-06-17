package me.jkong.mybatis;

import me.jkong.mybatis.io.Resources;
import me.jkong.mybatis.dao.IUserDao;
import me.jkong.mybatis.entity.User;
import me.jkong.mybatis.session.SqlSession;
import me.jkong.mybatis.session.SqlSessionFactory;
import me.jkong.mybatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 测试JKong MyBatis 整体流程
 *
 * @author JKong
 * @version v0.0.1
 * @date 2020/6/17 16:04.
 */
public class JKongMyBatisMainDemo {

    public static void main(String[] args) throws Exception {

        InputStream resourceAsSteam = Resources.getResourceAsSteam("/jkong-mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 查询所有记录
        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }

        // 查询一条数据
        User user = new User();
        user.setId(1L);
        user.setUsername("JKong");
        System.out.println(userDao.selectOne(user));
    }

}