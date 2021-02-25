/**
 * Created with JackHou
 * Date: 2021/2/24
 * Time: 18:00
 * Description:
 */

package com.qtimes.jetpackdemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qtimes.jetpackdemo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

public class WelcomeFragment extends Fragment {

    Button btnLogin, btnRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnLogin = view.findViewById(R.id.btn_login);
        btnRegister = view.findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(v -> {
            // 设置动画参数
            NavOptions navOptions = new NavOptions.Builder()
                    .setEnterAnim(android.R.anim.slide_in_left)//2进入的动画
                    .setExitAnim(android.R.anim.slide_out_right)//1退出的动画
                    .setPopEnterAnim(android.R.anim.slide_in_left)//按下返回键时1进入的动画
                    .setPopExitAnim(android.R.anim.slide_out_right)//按下返回键时2退出的动画
                    .build();
            Bundle bundle = new WelcomeFragmentArgs.Builder().setName("jack").build().toBundle();
            Navigation.findNavController(view).navigate(R.id.loginFragment, bundle, navOptions);
        });

        btnRegister.setOnClickListener(v -> {
            NavOptions navOptions = new NavOptions.Builder().build();
            Bundle bundle = new Bundle();
            Navigation.findNavController(view).navigate(R.id.registerFragment, bundle, navOptions);
        });
    }
}
