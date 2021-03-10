/**
 * Created with JackHou
 * Date: 2021/3/3
 * Time: 16:26
 * Description:Application
 */

package com.qtimes.jetpackdemo.common;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;
import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class BaseApplication extends Application {
    public static Application mContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
        mContext = this;
    }

    public static Application getContext() {
        return mContext;
    }
}
