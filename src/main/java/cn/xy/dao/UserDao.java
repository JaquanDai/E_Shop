package cn.xy.dao;

import cn.xy.bean.User;

import java.util.List;

public interface UserDao {

    //查找用户
    User getUser(int userId);

    //搜索所有用户
    List<User> getAllUser();

    //添加用户
    void addUser(User user);

    //删除用户
    void delUser(int userId);

    //添加地址
    void addAddress(int userId,String address);

    //删除地址
    void delAddress(int uaId);

    //修改地址
    void modifyAddress(int uaId,String address);

    //设置默认地址
    void setAddress(int uaId,String address);

    //修改用户电话
    void modifyUserPhone(int userId,String Phone);

    //修改用户昵称
    void modifyUsername(int userId,String username);

    //判断账号是否重复
    User checkUserAccount(String userAccount);




}
