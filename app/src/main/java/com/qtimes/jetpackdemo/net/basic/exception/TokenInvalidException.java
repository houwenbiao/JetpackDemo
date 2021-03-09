/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:01
 * Description:Token失效异常
 */

package com.qtimes.jetpackdemo.net.basic.exception;

import com.qtimes.jetpackdemo.net.basic.config.HttpConfig.HttpCode;

public class TokenInvalidException extends BaseException {

    public TokenInvalidException() {
        super(HttpCode.CODE_TOKEN_INVALID, "Token失效");
    }
}
