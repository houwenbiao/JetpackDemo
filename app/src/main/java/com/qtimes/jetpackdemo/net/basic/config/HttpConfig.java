/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 13:54
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.config;

public class HttpConfig {

    public static final long READ_TIMEOUT = 6000;
    public static final long WRITE_TIMEOUT = 6000;
    public static final long CONNECT_TIMEOUT = 6000;

    public static final String KEY = "key";
    public static final String HTTP_REQUEST_TYPE_KEY = "requestType";

    /*天气请求相关配置*/
    public static final String BASE_URL_DEFAULT = "http://op.juhe.cn/";
    public static final String BASE_URL_WEATHER = "http://op.juhe.cn/";
    public static final String KEY_WEATHER = "afc28ae28c6f1b520dab5d1ed537f6c0";

    //新闻
    public static final String BASE_URL_NEWS = "http://v.juhe.cn/";
    public static final String KEY_NEWS = "c3f9d6c4c70559205cab02fb9f8d4a66";

    /**
     * 请求类型
     **/
    public interface RequestType {
        String WEATHER = "weather";
        String NEWS = "news";
    }

    /**
     * http code
     */
    public interface HttpCode {
        int CODE_SUCCESS = 0;
        int CODE_UNKNOWN = -1;
        int CODE_TOKEN_INVALID = -2;
        int CODE_ACCOUNT_INVALID = -3;
        int CODE_PARAMETER_INVALID = -4;
        int CODE_CONNECTION_FAILED = -5;
        int CODE_FORBIDDEN = -6;
        int CODE_RESULT_INVALID = -7;
    }


}
