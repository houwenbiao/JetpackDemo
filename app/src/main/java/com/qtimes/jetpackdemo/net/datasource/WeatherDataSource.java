/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 17:30
 * Description:天气相关网络请求数据源
 */

package com.qtimes.jetpackdemo.net.datasource;

import com.qtimes.jetpackdemo.bean.Weather;
import com.qtimes.jetpackdemo.net.basic.base.BaseRemoteDataSource;
import com.qtimes.jetpackdemo.net.basic.callback.RequestCallback;
import com.qtimes.jetpackdemo.net.datasource.base.IWeatherDataSource;
import com.qtimes.jetpackdemo.net.service.ApiService;

import javax.inject.Inject;

public class WeatherDataSource extends BaseRemoteDataSource implements IWeatherDataSource {

    @Inject
    public WeatherDataSource() {
        super();
    }

    @Override
    public void queryWeather(String cityName, RequestCallback<Weather> callback) {
        execute(getService(ApiService.class).queryWeather(cityName), callback);
    }
}
