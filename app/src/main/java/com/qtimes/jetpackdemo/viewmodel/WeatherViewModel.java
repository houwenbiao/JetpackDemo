/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 17:37
 * Description:天气ViewModel
 */

package com.qtimes.jetpackdemo.viewmodel;

import com.qtimes.jetpackdemo.data.Weather;
import com.qtimes.jetpackdemo.repository.RepositoryProvider;
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
        startLoading();
        LogUtil.d("queryWeather");
        if (cityName.getValue() == null) {
            return;
        }
        mWeatherRepository.queryWeather(StringUtil.replaceBlank(cityName.getValue()))
                .observe(mLifecycleOwner, weather -> mWeatherMutableLiveData.postValue(weather));
    }

    public MutableLiveData<String> getCityName() {
        return cityName;
    }

    public MutableLiveData<Weather> getWeatherMutableLiveData() {
        return mWeatherMutableLiveData;
    }
}
