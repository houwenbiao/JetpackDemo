/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 16:44
 * Description:
 */

package com.qtimes.jetpackdemo.net.basic.base;

public class BaseRepo<T> {
    protected T remoteDataSource;

    public BaseRepo(T remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }
}
