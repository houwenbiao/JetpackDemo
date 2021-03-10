/**
 * Created with JackHou
 * Date: 2021/3/10
 * Time: 13:44
 * Description:
 */

package com.qtimes.jetpackdemo.module;

import android.content.Context;

import com.qtimes.jetpackdemo.db.AppDataBase;
import com.qtimes.jetpackdemo.db.dao.FavoriteShoeDao;
import com.qtimes.jetpackdemo.db.dao.ShoeDao;
import com.qtimes.jetpackdemo.db.dao.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@Module
@InstallIn(ApplicationComponent.class)
public class DBModule {

    @Singleton
    @Provides
    AppDataBase providesAppDataBase(@ApplicationContext Context context) {
        return AppDataBase.buildDatabase(context);
    }

    @Singleton
    @Provides
    UserDao providesUserDao(AppDataBase appDataBase) {
        return appDataBase.getUserDao();
    }

    @Singleton
    @Provides
    ShoeDao providesShoeDao(AppDataBase appDataBase) {
        return appDataBase.getShoeDao();
    }

    @Singleton
    @Provides
    FavoriteShoeDao providesFavoriteShoeDao(AppDataBase appDataBase) {
        return appDataBase.getFavoriteShoeDao();
    }
}
