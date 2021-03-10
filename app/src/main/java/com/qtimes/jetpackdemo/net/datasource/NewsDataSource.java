/**
 * Created with JackHou
 * Date: 2021/3/9
 * Time: 16:43
 * Description:
 */

package com.qtimes.jetpackdemo.net.datasource;

import com.qtimes.jetpackdemo.data.NewsPack;
import com.qtimes.jetpackdemo.net.RetrofitManager;
import com.qtimes.jetpackdemo.net.basic.base.BaseRemoteDataSource;
import com.qtimes.jetpackdemo.net.basic.callback.RequestCallback;
import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;
import com.qtimes.jetpackdemo.net.datasource.base.INewsDataSource;
import com.qtimes.jetpackdemo.net.service.ApiService;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

import javax.inject.Inject;

public class NewsDataSource extends BaseRemoteDataSource implements INewsDataSource {

    @Inject
    public NewsDataSource() {
        super();
    }

    @Override
    public void getNews(RequestCallback<NewsPack> callback) {
        execute(mRetrofitManager
                        .getService(ApiService.class, HttpConfig.BASE_URL_NEWS)
                        .getNews(),
                callback);
    }
}
