/**
 * Created with JackHou
 * Date: 2021/3/2
 * Time: 10:16
 * Description:用户处理的仓库
 */

package com.qtimes.jetpackdemo.repository;

import com.qtimes.jetpackdemo.db.bean.User;
import com.qtimes.jetpackdemo.db.dao.UserDao;
import com.qtimes.jetpackdemo.net.basic.base.BaseRepository;
import com.qtimes.jetpackdemo.net.datasource.UserDataSource;
import com.qtimes.jetpackdemo.net.datasource.base.IUserDataSource;

import javax.inject.Inject;

public class UserRepository extends BaseRepository<IUserDataSource> {

    UserDao mUserDao;

    @Inject
    public UserRepository(UserDao userDao, UserDataSource dataSource) {
        super(dataSource);
        mUserDao = userDao;
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
     *
     * @param account 用户名
     * @return User
     */
    public User findUserByAccount(String account) {
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
     * 更新用户信息
     *
     * @param user user
     * @return id
     */
    public int updateUser(User user) {
        return mUserDao.updateUser(user);
    }


    /**
     * 注销用户
     *
     * @param user 用户
     */
    public void unregister(User user) {
        mUserDao.deleteUser(user);
    }

    /**
     * 查询一登录用户
     *
     * @return user
     */
    public User getLoginUser() {
        return mUserDao.findLoginUser();
    }
}
