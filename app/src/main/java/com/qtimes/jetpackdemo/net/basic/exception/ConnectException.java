/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:05
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.exception;

import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;

public class ConnectException extends BaseException {
    public ConnectException() {
        super(HttpConfig.HttpCode.CODE_CONNECTION_FAILED, "网络请求失败");
    }
}
