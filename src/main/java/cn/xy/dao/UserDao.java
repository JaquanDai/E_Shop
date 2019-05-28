package cn.xy.dao;

import cn.xy.bean.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUser(int userId);


}
