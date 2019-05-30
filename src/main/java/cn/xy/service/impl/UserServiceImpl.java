package cn.xy.service.impl;

import cn.xy.bean.User;
import cn.xy.dao.UserDao;
import cn.xy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public User findUserById(int userId) {

        return this.userDao.getUser(userId);
    }
}
