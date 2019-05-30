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
        return null;
    }

    public void addUser(User user) {

    }

    public void delUser(int userId) {

    }

    public void addAddress(int userId, String address) {

    }

    public void delAddress(int uaId) {

    }

    public void modifyAddress(int uaId, String address) {

    }

    public void setAddress(int uaId, String address) {

    }

    public void modifyUserPhone(int userId, String Phone) {

    }

    public void modigyUsername(int userId, String username) {

    }
}
