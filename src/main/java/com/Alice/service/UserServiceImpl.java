package com.Alice.service;

import com.Alice.dao.UserDao;
import com.Alice.domain.User;
import com.Alice.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户的业务层
 */
@Transactional
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 通过登录名进行校验
     * @param user_code
     * @return
     */
    public User checkCode(String user_code) {
        return userDao.checkCode(user_code);
    }

    /**
     * 保存用户 密码需要加密
     * @param user
     */
    public void save(User user) {
        String pwd = user.getUser_password();
        user.setUser_password(MD5Utils.md5(pwd));
        user.setUser_state("1");
        //调用持久层
        userDao.save(user);
    }

    /**
     * 用户登录的方法
     * @param user
     * @return
     */
    public User login(User user) {
        String pwd = user.getUser_password();
        // 给密码加密
        user.setUser_password(MD5Utils.md5(pwd));
        // 查询
        return userDao.login(user);
    }
}
