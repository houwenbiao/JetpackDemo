/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:12
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.exception;

import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;

public class ForbiddenException extends BaseException {
    public ForbiddenException() {
        super(HttpConfig.HttpCode.CODE_FORBIDDEN, "404错误");
    }
}
