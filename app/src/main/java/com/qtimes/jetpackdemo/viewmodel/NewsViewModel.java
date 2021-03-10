/**
 * Created with JackHou
 * Date: 2021/3/9
 * Time: 16:51
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel;

import com.qtimes.jetpackdemo.data.NewsPack;
import com.qtimes.jetpackdemo.repository.NewsRepository;
import com.qtimes.jetpackdemo.repository.RepositoryProvider;
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
        mNewsRepository.getNews().observe(mLifecycleOwner, new Observer<NewsPack>() {
            @Override
            public void onChanged(NewsPack newsPack) {
                mNewsPackMutableLiveData.postValue(newsPack);
            }
        });
    }
}
