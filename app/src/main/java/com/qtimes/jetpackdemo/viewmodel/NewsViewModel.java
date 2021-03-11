/**
 * Created with JackHou
 * Date: 2021/3/9
 * Time: 16:51
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel;

import com.qtimes.jetpackdemo.bean.NewsPack;
import com.qtimes.jetpackdemo.net.basic.callback.RequestMultiplyCallback;
import com.qtimes.jetpackdemo.net.basic.exception.BaseException;
import com.qtimes.jetpackdemo.repository.NewsRepository;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class NewsViewModel extends BaseViewModel {
    private MutableLiveData<NewsPack> mNewsPackMutableLiveData;
    private NewsRepository mNewsRepository;

    @ViewModelInject
    public NewsViewModel(NewsRepository newsRepository) {
        this.mNewsRepository = newsRepository;
        mNewsPackMutableLiveData = new MutableLiveData<>();
    }

    public void getNews() {
        startLoading();
        mNewsRepository.getNews(new RequestMultiplyCallback<NewsPack>() {
            @Override
            public void onFailed(BaseException e) {
                dismissLoading();
            }

            @Override
            public void onSuccess(NewsPack newsPack) {
                mNewsPackMutableLiveData.postValue(newsPack);
                dismissLoading();
            }
        });
    }
}
