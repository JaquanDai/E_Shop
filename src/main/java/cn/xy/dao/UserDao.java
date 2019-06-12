package cn.xy.dao;

import cn.xy.bean.User;
import cn.xy.bean.UserAddress;
import org.apache.ibatis.annotations.Param;

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
    void addAddress(UserAddress userAddress);

    //删除地址
    void delAddress(int uaId);

    //修改地址
    void modifyAddress(@Param("uaId")int uaId, @Param("address")String address);

    //设置默认地址
    void setAddress(int uaId);

    //修改用户电话
    void modifyUserPhone(@Param("userId")int userId, @Param("Phone")String Phone);

    //修改用户昵称
    void modifyUsername(@Param("userId")int userId, @Param("username")String username);

    //修改用户密码
    void modifyUserPwd(@Param("userId")int userId, @Param("pwd")String pwd);

    //判断账号是否重复
    User checkUserAccount(String userAccount);

    //得到用户的第一个地址
    String getFirstAddress(int userId);

    //得到用户默认地址
    String getDefaultAddress(int userId);

    //判断地址是否存在
    UserAddress checkUserAddress(@Param("userId")int userId, @Param("address")String address);

    //得到用户的所有地址
    List<UserAddress> getAllAddress(int userId);

    //取消该地址为默认地址
    void changeAddressStatusByUAId(int uaId);

    //取消该用户下的默认地址
    void changeAddressStatusByUserId(int userId);
}
