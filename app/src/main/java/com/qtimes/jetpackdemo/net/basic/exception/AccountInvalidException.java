/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:04
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.exception;

import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;

public class AccountInvalidException extends BaseException {
    public AccountInvalidException() {
        super(HttpConfig.HttpCode.CODE_ACCOUNT_INVALID, "账号或密码错误");
    }
}
