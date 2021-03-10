/**
 * Created with JackHou
 * Date: 2021/3/9
 * Time: 16:47
 * Description:
 */

package com.qtimes.jetpackdemo.repository;

import com.qtimes.jetpackdemo.data.NewsPack;
import com.qtimes.jetpackdemo.net.basic.base.BaseRepository;
import com.qtimes.jetpackdemo.net.basic.callback.RequestCallback;
import com.qtimes.jetpackdemo.net.datasource.NewsDataSource;
import com.qtimes.jetpackdemo.net.datasource.base.INewsDataSource;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;

public class NewsRepository extends BaseRepository<INewsDataSource> {

    @Inject
    public NewsRepository(NewsDataSource remoteDataSource) {
        super(remoteDataSource);
    }

    public MutableLiveData<NewsPack> getNews() {
        MutableLiveData<NewsPack> newsPackMutableLiveData = new MutableLiveData<>();
        remoteDataSource.getNews(new RequestCallback<NewsPack>() {
            @Override
            public void onSuccess(NewsPack newsPack) {
                newsPackMutableLiveData.postValue(newsPack);
            }
        });
        return newsPackMutableLiveData;
    }
}
