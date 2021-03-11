/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 17:37
 * Description:天气ViewModel
 */

package com.qtimes.jetpackdemo.viewmodel;

import com.qtimes.jetpackdemo.bean.Weather;
import com.qtimes.jetpackdemo.net.basic.callback.RequestMultiplyCallback;
import com.qtimes.jetpackdemo.net.basic.exception.BaseException;
import com.qtimes.jetpackdemo.repository.WeatherRepository;
import com.qtimes.jetpackdemo.utils.LogUtil;
import com.qtimes.jetpackdemo.utils.StringUtil;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;

public class WeatherViewModel extends BaseViewModel {
    private MutableLiveData<Weather> mWeatherMutableLiveData;
    private MutableLiveData<String> cityName;
    private final WeatherRepository mWeatherRepository;

    @ViewModelInject
    public WeatherViewModel(WeatherRepository weatherRepository) {
        this.mWeatherRepository = weatherRepository;
        mWeatherMutableLiveData = new MutableLiveData<>();
        cityName = new MutableLiveData<>();
    }

    public void queryWeather() {
        LogUtil.d("queryWeather");
        if (cityName.getValue() == null) {
            return;
        }
        startLoading(String.format("查询%s的天气", cityName.getValue()));
        mWeatherRepository.queryWeather(StringUtil.replaceBlank(cityName.getValue()),
                new RequestMultiplyCallback<Weather>() {
                    @Override
                    public void onFailed(BaseException e) {
                        dismissLoading();
                    }

                    @Override
                    public void onSuccess(Weather weather) {
                        mWeatherMutableLiveData.postValue(weather);
                        dismissLoading();
                    }
                });
    }

    public MutableLiveData<String> getCityName() {
        return cityName;
    }

    public MutableLiveData<Weather> getWeatherMutableLiveData() {
        return mWeatherMutableLiveData;
    }
}
