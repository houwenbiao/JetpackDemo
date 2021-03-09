/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:07
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.exception;

import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;

public class ParameterInvalidException extends BaseException {

    public ParameterInvalidException() {
        super(HttpConfig.HttpCode.CODE_PARAMETER_INVALID, "参数错误");
    }
}
