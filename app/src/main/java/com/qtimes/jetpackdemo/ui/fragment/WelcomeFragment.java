/**
 * Created with JackHou
 * Date: 2021/2/24
 * Time: 18:00
 * Description:欢迎页面
 */

package com.qtimes.jetpackdemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.databinding.FragmentWelcomeBinding;
import com.qtimes.jetpackdemo.viewmodel.CustomViewModelProvider;
import com.qtimes.jetpackdemo.viewmodel.WelcomeViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

public class WelcomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentWelcomeBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_welcome, container, false);
        WelcomeViewModel welcomeViewModel = CustomViewModelProvider
                .providerWelcomeModel(getContext(), Navigation.findNavController(container))
                .create(WelcomeViewModel.class);
        binding.setWelcomeModel(welcomeViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
