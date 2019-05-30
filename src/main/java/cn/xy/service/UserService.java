package cn.xy.service;

import cn.xy.bean.User;

import java.util.List;

public interface UserService {
    //查找指定用户
    User findUserById(int userId);
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
    void modigyUsername(int userId,String username);

}
