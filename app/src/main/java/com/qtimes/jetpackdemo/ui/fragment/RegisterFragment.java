/**
 * Created with JackHou
 * Date: 2021/2/24
 * Time: 18:31
 * Description:
 */

package com.qtimes.jetpackdemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.databinding.FragmentRegisterBinding;
import com.qtimes.jetpackdemo.db.AppDataBase;
import com.qtimes.jetpackdemo.db.repository.UserRepository;
import com.qtimes.jetpackdemo.viewmodel.CustomViewModelProvider;
import com.qtimes.jetpackdemo.viewmodel.RegisterViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class RegisterFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentRegisterBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_register, container, false);
        RegisterViewModel model = CustomViewModelProvider
                .providerRegisterModel(getContext(), Navigation.findNavController(container))
                .create(RegisterViewModel.class);
        binding.setRegisterModel(model);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
