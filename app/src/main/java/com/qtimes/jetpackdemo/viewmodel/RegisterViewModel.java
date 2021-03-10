/**
 * Created with JackHou
 * Date: 2021/3/2
 * Time: 18:20
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel;

import android.util.Log;

import com.qtimes.jetpackdemo.db.AppDataBase;
import com.qtimes.jetpackdemo.db.bean.User;
import com.qtimes.jetpackdemo.repository.RepositoryProvider;
import com.qtimes.jetpackdemo.repository.UserRepository;
import com.qtimes.jetpackdemo.ui.fragment.RegisterFragmentDirections;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import dagger.hilt.android.scopes.ActivityRetainedScoped;

public class RegisterViewModel extends BaseViewModel {
    private static final String TAG = "RegisterViewModel";

    UserRepository mUserRepository;

    public MutableLiveData<String> account = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    @ViewModelInject
    public RegisterViewModel(UserRepository userRepository) {
        this.mUserRepository = userRepository;
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
