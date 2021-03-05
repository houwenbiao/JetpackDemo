/**
 * Created with JackHou
 * Date: 2021/3/5
 * Time: 11:48
 * Description:
 */

package com.qtimes.jetpackdemo.db.repository;

import android.content.Context;

import com.qtimes.jetpackdemo.db.AppDataBase;

public class RepositoryProvider {
    public static UserRepository providerUserRepository(Context context) {
        return UserRepository.getInstance(AppDataBase.getInstance(context).getUserDao());
    }
}
