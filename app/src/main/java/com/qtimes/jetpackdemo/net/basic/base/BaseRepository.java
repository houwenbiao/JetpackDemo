/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 16:44
 * Description:基础代理类
 */

package com.qtimes.jetpackdemo.net.basic.base;

public class BaseRepository<T> {
    protected T remoteDataSource;

    public BaseRepository(T remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }
}
