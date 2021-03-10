/**
 * Created with JackHou
 * Date: 2021/3/10
 * Time: 14:05
 * Description:
 */

package com.qtimes.jetpackdemo.net.datasource;

import com.qtimes.jetpackdemo.net.basic.base.BaseRemoteDataSource;
import com.qtimes.jetpackdemo.net.datasource.base.IUserDataSource;

import javax.inject.Inject;

public class UserDataSource extends BaseRemoteDataSource implements IUserDataSource {

    @Inject
    public UserDataSource() {
        super();
    }
}
