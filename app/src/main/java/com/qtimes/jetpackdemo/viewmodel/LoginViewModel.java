/**
 * Created with JackHou
 * Date: 2021/2/25
 * Time: 14:41
 * Description:DataBinding 用户登录model
 */

package com.qtimes.jetpackdemo.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.db.AppDataBase;
import com.qtimes.jetpackdemo.db.data.User;
import com.qtimes.jetpackdemo.db.repository.UserRepository;
import com.qtimes.jetpackdemo.ui.activity.MainActivity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    private final Context mContext;
    private final UserRepository mUserRepository;

    public LoginViewModel(Context context) {
        mContext = context;
        mUserRepository = UserRepository.getInstance(AppDataBase.getInstance(mContext).getUserDao());
    }

    public void login() {
        if (name.getValue() == null || name.getValue().length() == 0) {
            Toast.makeText(mContext, mContext.getString(R.string.txt_input_account_err),
                    Toast.LENGTH_SHORT).show();
            return;
        }
        User localUser = mUserRepository.findUserByAccount(name.getValue());
        if (!localUser.getPassword().equals(password.getValue())) {
            Toast.makeText(mContext, mContext.getString(R.string.txt_input_pwd_err),
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(mContext, mContext.getString(R.string.txt_login_success),
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }
}
