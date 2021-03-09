/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:26
 * Description:请求成功的回调
 */

package com.qtimes.jetpackdemo.net.basic.callback;

public interface RequestCallback<T> {
    void onSuccess(T t);
}
