package pers.eter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.eter.dao.UserDao;
import pers.eter.core.model.User;

import java.util.List;

/**
 * Created by Eter on 17-6-5.
 */
@Service
//@SuppressWarnings("all")
public class UserService {
    @Autowired
    private UserDao userDao;

    public Integer add(User user) {
        int count = userDao.insert(user);
        System.out.println("插入记录" + count);
        return user.getUserId();
    }

    public List<User> find(String uname) {
        List<User> users = userDao.find(uname);
        return users;
    }
}
