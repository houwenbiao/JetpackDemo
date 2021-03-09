/**
 * Created with JackHou
 * Date: 2021/3/3
 * Time: 18:39
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel;

import android.content.Intent;

import com.qtimes.jetpackdemo.db.AppDataBase;
import com.qtimes.jetpackdemo.db.data.User;
import com.qtimes.jetpackdemo.db.repository.UserRepository;
import com.qtimes.jetpackdemo.ui.activity.MainActivity;
import com.qtimes.jetpackdemo.ui.fragment.WelcomeFragmentDirections;
import com.qtimes.jetpackdemo.utils.LogUtil;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

public class WelcomeViewModel extends BaseViewModel {
    private UserRepository mUserRepository;

    public WelcomeViewModel() {
        mUserRepository = UserRepository.getInstance(AppDataBase.getInstance(mContext).getUserDao());
        User loginUser = mUserRepository.getLoginUser();
        if (loginUser != null) {
            mContext.startActivity(new Intent(mContext, MainActivity.class));
        }
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
