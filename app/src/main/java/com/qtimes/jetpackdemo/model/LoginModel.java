/**
 * Created with JackHou
 * Date: 2021/2/25
 * Time: 14:41
 * Description:DataBinding 用户登录model
 */

package com.qtimes.jetpackdemo.model;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.qtimes.jetpackdemo.ui.activity.MainActivity;

import java.util.Objects;

import androidx.databinding.ObservableField;

public class LoginModel {
    public final ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();
    Context mContext;

    public LoginModel(Context context) {
        mContext = context;
    }

    public void login() {
        if (Objects.equals(name.get(), "jack") &&
                Objects.equals(password.get(), "123456")) {
            Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext, MainActivity.class);
            mContext.startActivity(intent);
        } else {
            Toast.makeText(mContext, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}
