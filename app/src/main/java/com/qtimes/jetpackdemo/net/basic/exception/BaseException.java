/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 13:37
 * Description:BaseException
 */

package com.qtimes.jetpackdemo.net.basic.exception;


import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;

public class BaseException extends RuntimeException {
    private int httpCode = HttpConfig.HttpCode.CODE_UNKNOWN;

    public BaseException() {
    }

    public BaseException(int httpCode, String message) {
        super(message);
        this.httpCode = httpCode;
    }

    public int getHttpCode() {
        return httpCode;
    }
}
