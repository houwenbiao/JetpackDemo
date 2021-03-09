/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 15:33
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.interceptor;

import com.qtimes.jetpackdemo.net.basic.config.HttpConfig;
import com.qtimes.jetpackdemo.net.basic.config.HttpConfig.RequestType;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class FilterInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl.Builder builder = originalRequest.url().newBuilder();
        Headers headers = originalRequest.headers();
        if (headers != null && headers.size() > 0) {
            String reqType = headers.get(HttpConfig.HTTP_REQUEST_TYPE_KEY);
            if (reqType != null && reqType.length() > 0) {
                switch (reqType) {
                    case RequestType.WEATHER:
                        builder.addQueryParameter(HttpConfig.KEY, HttpConfig.KEY_WEATHER);
                        break;
                    case RequestType.NEWS:
                        builder.addQueryParameter(HttpConfig.KEY, HttpConfig.KEY_NEWS);
                    default:
                        break;
                }
            }
        }
        Request.Builder reqBuilder = originalRequest
                .newBuilder()
                .removeHeader(HttpConfig.HTTP_REQUEST_TYPE_KEY)
                .url(builder.build());
        return chain.proceed(reqBuilder.build());
    }
}
