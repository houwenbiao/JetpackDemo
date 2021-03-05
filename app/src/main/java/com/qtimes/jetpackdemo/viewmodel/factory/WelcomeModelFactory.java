/**
 * Created with JackHou
 * Date: 2021/3/5
 * Time: 11:34
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel.factory;

import android.content.Context;

import com.qtimes.jetpackdemo.viewmodel.WelcomeViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

public class WelcomeModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final NavController mNavController;
    private final Context mContext;

    public WelcomeModelFactory(Context context, NavController navController) {
        mNavController = navController;
        mContext = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new WelcomeViewModel(mNavController, mContext);
    }
}
