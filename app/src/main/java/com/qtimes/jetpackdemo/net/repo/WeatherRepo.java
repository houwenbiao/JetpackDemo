/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 17:33
 * Description:
 */

package com.qtimes.jetpackdemo.net.repo;

import com.qtimes.jetpackdemo.data.Weather;
import com.qtimes.jetpackdemo.net.basic.base.BaseRepo;
import com.qtimes.jetpackdemo.net.basic.callback.RequestCallback;
import com.qtimes.jetpackdemo.net.datasource.base.IWeatherDataSource;

import androidx.lifecycle.MutableLiveData;

public class WeatherRepo extends BaseRepo<IWeatherDataSource> {

    public WeatherRepo(IWeatherDataSource remoteDataSource) {
        super(remoteDataSource);
    }

    public MutableLiveData<Weather> queryWeather(String cityName) {
        MutableLiveData<Weather> weatherMutableLiveData = new MutableLiveData<>();
        remoteDataSource.queryWeather(cityName, new RequestCallback<Weather>() {
            @Override
            public void onSuccess(Weather weather) {
                weatherMutableLiveData.postValue(weather);
            }
        });
        return weatherMutableLiveData;
    }
}
