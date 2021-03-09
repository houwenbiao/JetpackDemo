/**
 * Created with JackHou
 * Date: 2021/3/2
 * Time: 18:20
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel;

import android.content.Context;
import android.util.Log;

import com.qtimes.jetpackdemo.db.AppDataBase;
import com.qtimes.jetpackdemo.db.data.User;
import com.qtimes.jetpackdemo.db.repository.UserRepository;
import com.qtimes.jetpackdemo.ui.fragment.RegisterFragmentDirections;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

public class RegisterViewModel extends BaseViewModel {
    private static final String TAG = "RegisterViewModel";

    private UserRepository mUserRepository;

    public MutableLiveData<String> account = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public RegisterViewModel() {
        mUserRepository = UserRepository.getInstance(AppDataBase.getInstance(mContext).getUserDao());
    }

    /**
     * 注册用户
     */
    public void register() {
        Log.d(TAG, "register");
        if (name.getValue() == null || account.getValue() == null || password.getValue() == null) {
            Log.e(TAG, "input error");
            return;
        }
        long userId = mUserRepository.register(account.getValue(), name.getValue(), password.getValue());
        User user = mUserRepository.findUserById(userId);
        Log.d(TAG, user.toString());
        RegisterFragmentDirections.ActionRegisterFragmentToLoginFragment action =
                RegisterFragmentDirections.actionRegisterFragmentToLoginFragment().setName(name.getValue());
        mNavController.navigate(action);
    }
}
