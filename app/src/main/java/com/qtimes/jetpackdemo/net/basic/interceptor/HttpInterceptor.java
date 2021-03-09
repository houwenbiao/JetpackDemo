/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 14:51
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.interceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

import com.qtimes.jetpackdemo.net.basic.exception.*;

public class HttpInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request req = chain.request();
        Response originalRes = chain.proceed(req);
        if (originalRes.code() != 200) {
            throw new ResultInvalidException();
        }
        BufferedSource source = originalRes.body().source();
        source.request(Integer.MAX_VALUE);
        String byteStr = source.getBuffer().snapshot().utf8();
        ResponseBody body = ResponseBody.create(null, byteStr);
        return originalRes.newBuilder().body(body).build();
    }
}
