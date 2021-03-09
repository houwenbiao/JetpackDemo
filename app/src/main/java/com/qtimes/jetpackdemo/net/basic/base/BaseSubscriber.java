/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 16:12
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.base;

import android.os.MessageQueue;

import com.qtimes.jetpackdemo.net.basic.callback.RequestCallback;
import com.qtimes.jetpackdemo.net.basic.callback.RequestMultiplyCallback;
import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;
import com.qtimes.jetpackdemo.net.basic.exception.BaseException;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class BaseSubscriber<T> extends DisposableObserver<T> {

    private RequestCallback<T> mRequestCallback;

    public BaseSubscriber(RequestCallback<T> requestCallback) {
        mRequestCallback = requestCallback;
    }

    @Override
    public void onNext(@NonNull T t) {
        if (mRequestCallback != null) {
            mRequestCallback.onSuccess(t);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (mRequestCallback instanceof RequestMultiplyCallback) {
            RequestMultiplyCallback callback = (RequestMultiplyCallback) mRequestCallback;
            if (e instanceof BaseException) {
                callback.onFailed((BaseException) e);
            } else {
                callback.onFailed(new BaseException(HttpConfig.HttpCode.CODE_UNKNOWN, e.getMessage()));
            }
        }
    }

    @Override
    public void onComplete() {

    }
}
