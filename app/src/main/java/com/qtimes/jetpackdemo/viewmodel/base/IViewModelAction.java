/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 9:56
 * Description:base ViewModel 实现的接口,用于接收到action之后处理相应的操作
 */

package com.qtimes.jetpackdemo.viewmodel.base;

import com.qtimes.jetpackdemo.event.base.BaseActionEvent;

import androidx.lifecycle.MutableLiveData;

public interface IViewModelAction {
    void startLoading();

    void startLoading(String msg);

    void dismissLoading();

    void showToast(String msg);

    void finish();

    void finishWithResultSuccess();

    MutableLiveData<BaseActionEvent> getActionLiveData();
}
