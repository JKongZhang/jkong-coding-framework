package me.jkong.mybatis.entity;

/**
 * 用户实体
 *
 * @author JKong
 * @version v0.0.1
 * @date 2020/6/16 10:45.
 */
public class User {

    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}