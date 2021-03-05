/**
 * Created with JackHou
 * Date: 2021/3/2
 * Time: 10:16
 * Description:用户处理的仓库
 */

package com.qtimes.jetpackdemo.db.repository;

import com.qtimes.jetpackdemo.db.dao.UserDao;
import com.qtimes.jetpackdemo.db.data.User;

import java.security.PublicKey;

public class UserRepository {
    private final UserDao mUserDao;
    private static UserRepository instance;

    private UserRepository(UserDao userDao) {
        mUserDao = userDao;
    }

    public static UserRepository getInstance(UserDao userDao) {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository(userDao);
                }
            }
        }
        return instance;
    }

    /**
     * 通过id查找用户
     *
     * @param id user 主键id
     * @return user
     */
    public User findUserById(long id) {
        return mUserDao.findUserById(id);
    }

    /**
     * 通过用户名
     * @param account 用户名
     * @return User
     */
    public User findUserByAccount(String account){
        return mUserDao.findUserByAccount(account);
    }


    /**
     * 注册用户
     *
     * @param account  用户账号
     * @param name     用户名
     * @param password 用户密码
     */
    public Long register(String account, String name, String password) {
        return mUserDao.registerUser(new User(account, name, password));
    }


    /**
     * 注销用户
     *
     * @param user 用户
     */
    public void unregister(User user) {
        mUserDao.deleteUser(user);
    }
}
