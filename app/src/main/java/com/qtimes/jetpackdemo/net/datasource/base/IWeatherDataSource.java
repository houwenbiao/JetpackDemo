/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 17:27
 * Description:
 */

package com.qtimes.jetpackdemo.net.datasource.base;

import com.qtimes.jetpackdemo.data.Weather;
import com.qtimes.jetpackdemo.net.basic.callback.RequestCallback;

public interface IWeatherDataSource {
    void queryWeather(String cityName, RequestCallback<Weather> callback);
}
