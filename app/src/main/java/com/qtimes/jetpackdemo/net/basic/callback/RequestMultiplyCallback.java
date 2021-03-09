/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:28
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.callback;

import com.qtimes.jetpackdemo.net.basic.exception.BaseException;

public interface RequestMultiplyCallback<T> extends RequestCallback<T> {
    void onFailed(BaseException e);
}
