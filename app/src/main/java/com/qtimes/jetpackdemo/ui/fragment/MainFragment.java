/**
 * Created with JackHou
 * Date: 2021/2/25
 * Time: 11:32
 * Description:
 */

package com.qtimes.jetpackdemo.ui.fragment;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.databinding.FragmentMainBinding;
import com.qtimes.jetpackdemo.ui.base.BaseFragment;
import com.qtimes.jetpackdemo.viewmodel.WeatherViewModel;
import com.qtimes.jetpackdemo.viewmodel.base.JViewModelProvider;

import androidx.lifecycle.ViewModel;

public class MainFragment extends BaseFragment {
    private WeatherViewModel mWeatherViewModel;

    @Override
    protected void bindingSetViewModels() {
        FragmentMainBinding binding = (FragmentMainBinding) mDataBinding;
        binding.setWeatherViewModel(mWeatherViewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected ViewModel initViewModel() {
        mWeatherViewModel = JViewModelProvider.get(this, WeatherViewModel.class);
        return mWeatherViewModel;
    }
}
