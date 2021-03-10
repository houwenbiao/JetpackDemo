/**
 * Created with JackHou
 * Date: 2021/2/25
 * Time: 11:32
 * Description:
 */

package com.qtimes.jetpackdemo.ui.fragment;

import com.qtimes.jetpackdemo.R;
import com.qtimes.jetpackdemo.databinding.FragmentNewsBinding;
import com.qtimes.jetpackdemo.ui.base.BaseFragment;
import com.qtimes.jetpackdemo.viewmodel.NewsViewModel;
import com.qtimes.jetpackdemo.viewmodel.base.JViewModelProvider;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsFragment extends BaseFragment {

    private NewsViewModel mNewsViewModel;

    @Override
    protected void bindingSetViewModels() {
        FragmentNewsBinding binding = (FragmentNewsBinding) mDataBinding;
        binding.setNewsViewModel(mNewsViewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected ViewModel initViewModel() {
        mNewsViewModel = JViewModelProvider.get(this, NewsViewModel.class, mNavController);
        return null;
    }
}
