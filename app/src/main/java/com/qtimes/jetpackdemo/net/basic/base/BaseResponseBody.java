/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:18
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.base;

import com.google.gson.annotations.SerializedName;

public class BaseResponseBody<T> {

    @SerializedName("error_code")
    private int code;

    @SerializedName("reason")
    private String msg;

    @SerializedName("result")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
