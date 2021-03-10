/**
 * Created with JackHou
 * Date: 2021/2/24
 * Time: 18:30
 * Description:登录界面UI
 */

package com.qtimes.jetpackdemo.ui.fragment;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.databinding.FragmentLoginBinding;
import com.qtimes.jetpackdemo.ui.base.BaseFragment;
import com.qtimes.jetpackdemo.viewmodel.LoginViewModel;
import com.qtimes.jetpackdemo.viewmodel.base.JViewModelProvider;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment {
    private static final String TAG = "LoginFragment";
    private LoginViewModel mLoginViewModel;

    @Override
    protected void bindingSetViewModels() {
        FragmentLoginBinding binding = (FragmentLoginBinding) mDataBinding;
        binding.setLoginViewModel(mLoginViewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected ViewModel initViewModel() {
        mLoginViewModel = JViewModelProvider.get(this, LoginViewModel.class, mNavController);
        return mLoginViewModel;
    }
}
