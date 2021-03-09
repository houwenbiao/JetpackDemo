/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 10:00
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel.base;

import android.annotation.SuppressLint;
import android.content.Context;

import com.qtimes.jetpackdemo.common.BaseApplication;
import com.qtimes.jetpackdemo.event.base.BaseActionEvent;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

public class BaseViewModel extends ViewModel implements IViewModelAction {

    private final MutableLiveData<BaseActionEvent> mActionLiveData;
    protected LifecycleOwner mLifecycleOwner;
    protected NavController mNavController;
    @SuppressLint("StaticFieldLeak")
    protected Context mContext;

    public BaseViewModel() {
        mContext = BaseApplication.getContext();
        mActionLiveData = new MutableLiveData<>();
    }

    @Override
    public void startLoading() {
        startLoading(null);
    }

    @Override
    public void startLoading(String msg) {
        BaseActionEvent event = new BaseActionEvent(BaseActionEvent.EVENT_SHOW_LOADING_DIALOG);
        event.setMessage(msg);
        mActionLiveData.postValue(event);
    }

    @Override
    public void dismissLoading() {
        BaseActionEvent event = new BaseActionEvent(BaseActionEvent.EVENT_DISMISS_LOADING_DIALOG);
        mActionLiveData.postValue(event);
    }

    @Override
    public void showToast(String msg) {
        BaseActionEvent event = new BaseActionEvent(BaseActionEvent.EVENT_SHOW_TOAST);
        event.setMessage(msg);
        mActionLiveData.postValue(event);
    }


    @Override
    public void finish() {
        BaseActionEvent event = new BaseActionEvent(BaseActionEvent.EVENT_FINISH);
        mActionLiveData.postValue(event);
    }

    @Override
    public void finishWithResultSuccess() {
        BaseActionEvent event = new BaseActionEvent(BaseActionEvent.EVENT_FINISH_WITH_RESULT_OK);
        mActionLiveData.postValue(event);
    }

    @Override
    public MutableLiveData<BaseActionEvent> getActionLiveData() {
        return mActionLiveData;
    }

    void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = lifecycleOwner;
    }

    void setNavController(NavController navController) {
        mNavController = navController;
    }
}
