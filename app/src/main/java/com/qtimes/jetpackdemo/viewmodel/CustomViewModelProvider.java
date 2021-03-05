/**
 * Created with JackHou
 * Date: 2021/3/5
 * Time: 11:40
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel;

import android.content.Context;

import com.qtimes.jetpackdemo.viewmodel.factory.LoginModelFactory;
import com.qtimes.jetpackdemo.viewmodel.factory.RegisterModelFactory;
import com.qtimes.jetpackdemo.viewmodel.factory.WelcomeModelFactory;

import androidx.navigation.NavController;

public class CustomViewModelProvider {

    public static WelcomeModelFactory providerWelcomeModel(Context context, NavController controller) {
        return new WelcomeModelFactory(context, controller);
    }

    public static LoginModelFactory providerLoginModel(Context context) {
        return new LoginModelFactory(context);
    }

    public static RegisterModelFactory providerRegisterModel(Context context, NavController controller) {
        return new RegisterModelFactory(context, controller);
    }
}
