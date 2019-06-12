package cn.xy.service;

import cn.xy.bean.User;
import cn.xy.bean.UserAddress;

import java.util.List;
import java.util.Map;

public interface UserService {
    //查找指定用户
    User findUserById(int userId);
    //搜索所有用户
    List<User> getAllUser();
    //添加用户
    Map<String,Object> addUser(User user);
    //删除用户
    void delUser(int userId);
    //添加地址
    Map<String,Object> addAddress(int userId, String address);
    //删除地址
    void delAddress(int uaId);
    //修改地址
    void modifyAddress(int uaId, String address);
    //设置默认地址
    void setAddress(int uaId, int userId);
    //修改用户电话
    void modifyUserPhone(int userId, String Phone);
    //修改用户昵称
    void modifyUsername(int userId, String username);
    //登录
    Map Login(String userAccount,String pwd);
    //检查密码是否正确
    Map checkPwd(int userId, String pwd);
    //修改用户密码
    void modifyUserPwd(int userId, String pwd);
    //得到用户所有的地址
    List<UserAddress> getAllUserAddress(int userId);
    //得到用户的默认地址
    String getDefaultAddress(int userId);
    //取消默认地址
    void cancelDefaultAddress(int uaId);
}
