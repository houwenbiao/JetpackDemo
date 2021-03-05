/**
 * Created with JackHou
 * Date: 2021/3/3
 * Time: 16:26
 * Description:
 */

package com.qtimes.jetpackdemo.common;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

public class App extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
