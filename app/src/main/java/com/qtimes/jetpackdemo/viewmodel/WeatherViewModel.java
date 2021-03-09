/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 17:37
 * Description:天气ViewModel
 */

package com.qtimes.jetpackdemo.viewmodel;

import com.qtimes.jetpackdemo.data.Weather;
import com.qtimes.jetpackdemo.net.datasource.WeatherDataSource;
import com.qtimes.jetpackdemo.net.repo.WeatherRepo;
import com.qtimes.jetpackdemo.utils.LogUtil;
import com.qtimes.jetpackdemo.utils.StringUtil;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

import androidx.lifecycle.MutableLiveData;

public class WeatherViewModel extends BaseViewModel {
    private MutableLiveData<Weather> mWeatherMutableLiveData;
    private MutableLiveData<String> cityName;
    private final WeatherRepo mWeatherRepo;

    public WeatherViewModel() {
        mWeatherMutableLiveData = new MutableLiveData<>();
        cityName = new MutableLiveData<>();
        mWeatherRepo = new WeatherRepo(new WeatherDataSource(this));
    }

    public void queryWeather() {
        startLoading();
        LogUtil.d("queryWeather");
        if (cityName.getValue() == null) {
            return;
        }
        mWeatherRepo.queryWeather(StringUtil.replaceBlank(cityName.getValue()))
                .observe(mLifecycleOwner, weather -> mWeatherMutableLiveData.postValue(weather));
    }

    public MutableLiveData<String> getCityName() {
        return cityName;
    }

    public MutableLiveData<Weather> getWeatherMutableLiveData() {
        return mWeatherMutableLiveData;
    }
}
