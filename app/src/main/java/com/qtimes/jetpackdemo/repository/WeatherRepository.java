/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 17:33
 * Description:天气代理类
 */

package com.qtimes.jetpackdemo.repository;

import com.qtimes.jetpackdemo.bean.Weather;
import com.qtimes.jetpackdemo.net.basic.base.BaseRepository;
import com.qtimes.jetpackdemo.net.basic.callback.RequestMultiplyCallback;
import com.qtimes.jetpackdemo.net.basic.exception.BaseException;
import com.qtimes.jetpackdemo.net.datasource.WeatherDataSource;
import com.qtimes.jetpackdemo.net.datasource.base.IWeatherDataSource;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;

public class WeatherRepository extends BaseRepository<IWeatherDataSource> {

    @Inject
    public WeatherRepository(WeatherDataSource remoteDataSource) {
        super(remoteDataSource);
    }

    public void  queryWeather(String cityName, RequestMultiplyCallback<Weather> callback) {
        remoteDataSource.queryWeather(cityName, callback);
    }
}
