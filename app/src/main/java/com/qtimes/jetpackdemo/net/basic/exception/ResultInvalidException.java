/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:11
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.exception;

import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;

public class ResultInvalidException extends BaseException {
    public ResultInvalidException() {
        super(HttpConfig.HttpCode.CODE_RESULT_INVALID, "无效请求");
    }
}
