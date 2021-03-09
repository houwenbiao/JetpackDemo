/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:09
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.exception;

public class ServerResultException extends BaseException {

    public ServerResultException(int httpCode, String message) {
        super(httpCode, message);
    }
}
