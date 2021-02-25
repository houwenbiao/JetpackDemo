/**
 * Created with JackHou
 * Date: 2021/2/24
 * Time: 18:30
 * Description:
 */

package com.qtimes.jetpackdemo.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.databinding.FragmentLoginBinding;
import com.qtimes.jetpackdemo.model.LoginModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {
    private static final String TAG = "LoginFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentLoginBinding fragmentLoginBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_login, container, false);
        LoginModel loginModel = new LoginModel(getContext());
        fragmentLoginBinding.setLoginModel(loginModel);
        return fragmentLoginBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = WelcomeFragmentArgs.fromBundle(bundle).getName();
            Log.d(TAG, name);
        }
    }


}
