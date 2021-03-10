/**
 * Created with JackHou
 * Date: 2021/2/25
 * Time: 11:32
 * Description:
 */

package com.qtimes.jetpackdemo.ui.fragment;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.ui.base.BaseFragment;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MeFragment extends BaseFragment {

    @Override
    protected void bindingSetViewModels() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_third;
    }

    @Override
    protected ViewModel initViewModel() {
        return null;
    }
}
