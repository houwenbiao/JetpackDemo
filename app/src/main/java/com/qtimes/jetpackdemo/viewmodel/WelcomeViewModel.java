/**
 * Created with JackHou
 * Date: 2021/3/3
 * Time: 18:39
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel;

import android.content.Context;

import com.qtimes.jetpackdemo.ui.fragment.WelcomeFragmentDirections;

import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

public class WelcomeViewModel extends ViewModel {
    private NavController mNavController;
    private Context mContext;

    public WelcomeViewModel(NavController navController, Context context) {
        mNavController = navController;
        mContext = context;
    }

    /**
     * 去登录的点击事件
     */
    public void goLoginClick() {
        mNavController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment());
    }

    /**
     * 加入我们点击事件
     */
    public void joinUsClick() {
        //注,xml中的动画需要配合此处的action方式跳转,
        //如果使用Navigation.findNavController(view).navigate(R.id.loginFragment, null, navOptions)
        //方式将无法使用xml中的动画效果
        mNavController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment());
    }
}
