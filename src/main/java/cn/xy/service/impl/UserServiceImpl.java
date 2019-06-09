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

    public  Map<String,Object> addAddress(int userId, String address) {
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
                result.put("code",0);
            }
        }
        else
        {
            this.userDao.addAddress(userId, address);
            result.put("code",0);
        }
        return result;
    }

    public void delAddress(int uaId) {
        this.userDao.delAddress(uaId);
    }

    public void modifyAddress(int uaId, String address) {
        this.userDao.modifyAddress(uaId, address);
    }

    public void setAddress(int uaId, String address) {
        this.userDao.setAddress(uaId, address);
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
}
