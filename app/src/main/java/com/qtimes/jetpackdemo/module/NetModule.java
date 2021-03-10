/**
 * Created with JackHou
 * Date: 2021/3/10
 * Time: 10:42
 * Description:
 */

package com.qtimes.jetpackdemo.module;

import com.qtimes.jetpackdemo.net.RetrofitManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class NetModule {

    @Singleton
    @Provides
    public RetrofitManager providesRetrofitManager() {
        return new RetrofitManager();
    }
}
