package com.qtimes.jetpackdemo.ui.activity;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.ui.base.BaseActivity;

import androidx.lifecycle.ViewModel;

public class WelcomeActivity extends BaseActivity {
    private static final String TAG = "WelcomeActivity";


    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void bindingSetViewModels() {

    }

    @Override
    protected ViewModel initViewModel() {
        return null;
    }
}