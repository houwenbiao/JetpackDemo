/**
 * Created with JackHou
 * Date: 2021/2/24
 * Time: 18:31
 * Description:
 */

package com.qtimes.jetpackdemo.ui.fragment;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.databinding.FragmentRegisterBinding;
import com.qtimes.jetpackdemo.ui.base.BaseFragment;
import com.qtimes.jetpackdemo.viewmodel.RegisterViewModel;
import com.qtimes.jetpackdemo.viewmodel.base.JViewModelProvider;

import androidx.lifecycle.ViewModel;

public class RegisterFragment extends BaseFragment {
    private RegisterViewModel mRegisterViewModel;

    @Override
    protected void bindingSetViewModels() {
        FragmentRegisterBinding binding = (FragmentRegisterBinding) mDataBinding;
        binding.setRegisterModel(mRegisterViewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected ViewModel initViewModel() {
        mRegisterViewModel = JViewModelProvider.get(
                this,
                RegisterViewModel.class,
                mNavController);
        return mRegisterViewModel;
    }
}
