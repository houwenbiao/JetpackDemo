/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 16:46
 * Description:
 */

package com.qtimes.jetpackdemo.net.service;

import com.qtimes.jetpackdemo.bean.NewsPack;
import com.qtimes.jetpackdemo.bean.Weather;
import com.qtimes.jetpackdemo.net.basic.base.BaseResponseBody;
import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({HttpConfig.HTTP_REQUEST_TYPE_KEY + ":" + HttpConfig.RequestType.WEATHER})
    @GET("onebox/weather/query")
    Observable<BaseResponseBody<Weather>> queryWeather(@Query("cityname") String cityName);

    @Headers({HttpConfig.HTTP_REQUEST_TYPE_KEY + ":" + HttpConfig.RequestType.NEWS})
    @GET("toutiao/index")
    Observable<BaseResponseBody<NewsPack>> getNews();
}
