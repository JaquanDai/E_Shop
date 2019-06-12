package cn.xy.service.impl;

import cn.xy.bean.User;
import cn.xy.bean.UserAddress;
import cn.xy.dao.UserDao;
import cn.xy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User findUserById(int userId) {
        return this.userDao.getUser(userId);
    }

    public List<User> getAllUser() {
        return this.userDao.getAllUser();
    }

    public  Map<String,Object> addUser(User user) {
        Map<String,Object> result = new HashMap<String, Object>();
        Boolean flag = true;
        User other = null;
        other = this.userDao.checkUserAccount(user.getUser_account());
        if (other != null)
        {
            result.put("code",-1);
            flag = false;
        }
        if (flag == false)
            return result;
        this.userDao.addUser(user);
        result.put("code",0);
        return result;
    }

    public void delUser(int userId) {
        this.userDao.delUser(userId);
    }

    public Map<String,Object> addAddress(int userId, String address) {
        Map<String,Object> result = new HashMap<String, Object>();
        UserAddress userAddress = null;
        userAddress = this.userDao.checkUserAddress(userId, address);
        if (userAddress != null)
        {
            if(userAddress.getStatus()==null || userAddress.getStatus().equals("default"))
            {
                result.put("code",-1);

            }
            else if (userAddress.getStatus().equals("delete"))
            {
                this.userDao.changeAddressStatusByUAId(userAddress.getUa_id());
                userAddress.setStatus(null);
                result.put("code",0);
            }
        }
        else
        {
            userAddress = new UserAddress();
            userAddress.setUser_id(userId);
            userAddress.setAddress(address);
            this.userDao.addAddress(userAddress);
            result.put("code",0);
        }
        result.put("userAddress",userAddress);
        return result;
    }

    public void delAddress(int uaId) {
        this.userDao.delAddress(uaId);
    }

    public void modifyAddress(int uaId, String address) {
        this.userDao.modifyAddress(uaId, address);
    }

    public void setAddress(int uaId, int userId) {
        this.userDao.changeAddressStatusByUserId(userId);
        this.userDao.setAddress(uaId);
    }

    public void modifyUserPhone(int userId, String Phone) {
        this.userDao.modifyUserPhone(userId, Phone);
    }

    public void modifyUsername(int userId, String username) {
        this.userDao.modifyUsername(userId, username);
    }

    public Map Login(String userAccount,String pwd) {
        Map<String,Object> map = new HashMap<>();
        User user = userDao.checkUserAccount(userAccount);

        if(user == null||!pwd.equals(user.getUser_pwd())){
            map.put("code", -1);
        }
        else {
            map.put("code", 0);
            map.put("userId",user.getUser_id());
        }
        return map;
    }

     public Map checkPwd(int userId, String pwd) {
        Map<String,Object> map = new HashMap<>();
        User user = userDao.getUser(userId);

        if(user == null||!pwd.equals(user.getUser_pwd())){
            map.put("code", -1);
        }
        else {
            map.put("code", 0);
        }
        return map;
    }

    public void modifyUserPwd(int userId, String pwd){
        this.userDao.modifyUserPwd(userId, pwd);
    }

    public List<UserAddress> getAllUserAddress(int userId){
        List<UserAddress> userAddresses = this.userDao.getAllAddress(userId);
        return userAddresses;
    }

    public String getDefaultAddress(int userId){
        String userAddress = this.userDao.getDefaultAddress(userId);
        if(userAddress == null)
            userAddress = this.userDao.getFirstAddress(userId);
        return userAddress;
    }

    public void cancelDefaultAddress(int uaId){
        this.userDao.changeAddressStatusByUAId(uaId);
    }
}
