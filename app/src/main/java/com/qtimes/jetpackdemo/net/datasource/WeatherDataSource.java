/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 17:30
 * Description:
 */

package com.qtimes.jetpackdemo.net.datasource;

import com.qtimes.jetpackdemo.data.Weather;
import com.qtimes.jetpackdemo.net.basic.base.BaseRemoteDataSource;
import com.qtimes.jetpackdemo.net.basic.callback.RequestCallback;
import com.qtimes.jetpackdemo.net.datasource.base.IWeatherDataSource;
import com.qtimes.jetpackdemo.net.service.ApiService;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

public class WeatherDataSource extends BaseRemoteDataSource implements IWeatherDataSource {

    public WeatherDataSource(BaseViewModel baseViewModel) {
        super(baseViewModel);
    }

    @Override
    public void queryWeather(String cityName, RequestCallback<Weather> callback) {
        execute(getService(ApiService.class).queryWeather(cityName), callback);
    }
}
