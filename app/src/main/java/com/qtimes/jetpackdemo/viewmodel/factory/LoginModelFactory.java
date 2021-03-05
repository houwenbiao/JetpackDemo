/**
 * Created with JackHou
 * Date: 2021/3/5
 * Time: 17:05
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel.factory;

import android.content.Context;

import com.qtimes.jetpackdemo.viewmodel.LoginViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LoginModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Context mContext;

    public LoginModelFactory(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(mContext);
    }
}
