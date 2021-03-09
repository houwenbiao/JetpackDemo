/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 16:19
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.base;

import com.qtimes.jetpackdemo.net.RetrofitManager;
import com.qtimes.jetpackdemo.net.basic.callback.RequestCallback;
import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;
import com.qtimes.jetpackdemo.viewmodel.base.BaseViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public abstract class BaseRemoteDataSource {
    private CompositeDisposable mCompositeDisposable;
    private BaseViewModel mBaseViewModel;

    public BaseRemoteDataSource(BaseViewModel baseViewModel) {
        mCompositeDisposable = new CompositeDisposable();
        mBaseViewModel = baseViewModel;
    }

    protected <T> T getService(Class<T> clazz) {
        return getService(clazz, HttpConfig.BASE_URL_DEFAULT);
    }

    protected <T> T getService(Class<T> clazz, String host) {
        return RetrofitManager.getInstance().getService(clazz, host);
    }

    private <T> ObservableTransformer<BaseResponseBody<T>, T> applySchedulers() {
        return RetrofitManager.getInstance().applySchedulers();
    }

    protected <T> void execute(Observable observable, RequestCallback<T> callback) {
        execute(observable, new BaseSubscriber<>(callback), true);
    }

    public <T> void executeWithoutDismiss(Observable observable, RequestCallback<T> callback) {
        execute(observable, new BaseSubscriber<>(callback), false);
    }

    protected <T> void executeQuietly(Observable observable, RequestCallback<T> callback) {
        executeQuietly(observable, new BaseSubscriber<>(callback));
    }

    private void execute(Observable observable, Observer observer, boolean isDismiss) {
        Disposable disposable = (Disposable) observable
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(applySchedulers())
                .compose(loadingTransformer(isDismiss))
                .subscribeWith(observer);
        addDisposable(disposable);
    }

    private void executeQuietly(Observable observable, Observer observer) {
        Disposable disposable = (Disposable) observable
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(applySchedulers())
                .subscribeWith(observer);
        addDisposable(disposable);
    }

    private void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    public void dispose() {
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    private void showLoading() {
        if (mBaseViewModel != null) {
            mBaseViewModel.startLoading();
        }
    }

    private void dismissLoading() {
        if (mBaseViewModel != null) {
            mBaseViewModel.dismissLoading();
        }
    }

    private <T> ObservableTransformer<T, T> loadingTransformer(boolean isDismiss) {
        return observable -> observable
                .subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> showLoading())
                .doFinally((Action) () -> {
                    if (isDismiss) {
                        dismissLoading();
                    }
                });
    }

}
