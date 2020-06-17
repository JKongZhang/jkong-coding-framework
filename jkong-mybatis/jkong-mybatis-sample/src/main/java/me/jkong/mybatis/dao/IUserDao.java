package me.jkong.mybatis.dao;

import me.jkong.mybatis.entity.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     * @throws Exception
     */
    public List<User> findAll() throws Exception;


    /**
     * 根据条件进行用户查询
     *
     * @param user
     * @return
     * @throws Exception
     */
    public User selectOne(User user) throws Exception;


}
