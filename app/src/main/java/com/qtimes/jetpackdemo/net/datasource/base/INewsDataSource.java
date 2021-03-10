/**
 * Created with JackHou
 * Date: 2021/3/9
 * Time: 16:39
 * Description:
 */

package com.qtimes.jetpackdemo.net.datasource.base;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.qtimes.jetpackdemo.data.NewsPack;
import com.qtimes.jetpackdemo.net.basic.callback.RequestCallback;

public interface INewsDataSource {
    void getNews(RequestCallback<NewsPack> callback);
}
