package cn.xy.service.impl;

import cn.xy.bean.User;
import cn.xy.dao.UserDao;
import cn.xy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public boolean addUser(User user) {
        if(this.userDao.checkUserAccount(user.getUser_account()).getUser_account().equals(user.getUser_account()))
            return false;
        this.userDao.addUser(user);
        return true;
    }

    public void delUser(int userId) {
        this.userDao.delUser(userId);
    }

    public void addAddress(int userId, String address) {
        this.userDao.addAddress(userId,address);
    }

    public void delAddress(int uaId) {
        this.userDao.delAddress(uaId);
    }

    public void modifyAddress(int uaId, String address) {
        this.userDao.modifyAddress(uaId,address);
    }

    public void setAddress(int uaId, String address) {
        this.userDao.setAddress(uaId,address);
    }

    public void modifyUserPhone(int userId, String Phone) {
        this.userDao.modifyUserPhone(userId,Phone);
    }

    public boolean modifyUsername(int userId, String username) {
        this.userDao.modifyUsername(userId,username);
        return true;
    }
}
