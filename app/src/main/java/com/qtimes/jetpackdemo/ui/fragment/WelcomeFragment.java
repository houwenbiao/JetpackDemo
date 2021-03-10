/**
 * Created with JackHou
 * Date: 2021/2/24
 * Time: 18:00
 * Description:欢迎页面
 */

package com.qtimes.jetpackdemo.ui.fragment;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.databinding.FragmentWelcomeBinding;
import com.qtimes.jetpackdemo.ui.base.BaseFragment;
import com.qtimes.jetpackdemo.viewmodel.WelcomeViewModel;
import com.qtimes.jetpackdemo.viewmodel.base.JViewModelProvider;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WelcomeFragment extends BaseFragment {

    WelcomeViewModel mWelcomeViewModel;

    @Override
    protected void bindingSetViewModels() {
        FragmentWelcomeBinding binding = (FragmentWelcomeBinding) mDataBinding;
        binding.setWelcomeModel(mWelcomeViewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_welcome;
    }

    @Override
    protected ViewModel initViewModel() {
        mWelcomeViewModel = JViewModelProvider.get(
                this,
                WelcomeViewModel.class,
                mNavController);
        return mWelcomeViewModel;
    }
}
