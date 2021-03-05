/**
 * Created with JackHou
 * Date: 2021/3/5
 * Time: 17:10
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel.factory;

import android.content.Context;

import com.qtimes.jetpackdemo.viewmodel.RegisterViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

public class RegisterModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Context mContext;
    private NavController mNavController;

    public RegisterModelFactory(Context context, NavController navController) {
        mContext = context;
        mNavController = navController;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RegisterViewModel(mContext, mNavController);
    }
}
