/**
 * Created with JackHou
 * Date: 2021/2/25
 * Time: 14:41
 * Description:DataBinding 用户登录model
 */

package com.qtimes.jetpackdemo.viewmodel;

import android.content.Intent;
import android.widget.Toast;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.db.bean.User;
import com.qtimes.jetpackdemo.db.enums.UserState;
import com.qtimes.jetpackdemo.repository.RepositoryProvider;
import com.qtimes.jetpackdemo.repository.UserRepository;
import com.qtimes.jetpackdemo.ui.activity.MainActivity;
import com.qtimes.jetpackdemo.ui.fragment.LoginFragmentDirections;
import com.qtimes.jetpackdemo.utils.LogUtil;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;


public class LoginViewModel extends BaseViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    UserRepository mUserRepository;

    @ViewModelInject
    public LoginViewModel(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    public void login() {
        if (name.getValue() == null || name.getValue().length() == 0) {
            Toast.makeText(mContext, mContext.getString(R.string.txt_input_account_err),
                    Toast.LENGTH_SHORT).show();
            return;
        }
        User localUser = mUserRepository.findUserByAccount(name.getValue());
        LogUtil.d("localUser: " + localUser);
        if (localUser == null) {
            showToast(mContext.getString(R.string.txt_user_unregister));
            mNavController.navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment());
            return;
        }
        if (!localUser.getPassword().equals(password.getValue())) {
            Toast.makeText(mContext, mContext.getString(R.string.txt_input_pwd_err),
                    Toast.LENGTH_SHORT).show();
            return;
        }
        localUser.setState(UserState.LOGIN.getStateId());
        mUserRepository.updateUser(localUser);
        Toast.makeText(mContext, mContext.getString(R.string.txt_login_success),
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }
}
