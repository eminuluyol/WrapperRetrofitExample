package com.taurus.emin.wrapperretrofitexample.api.callback;

/**
 * Created by Emin on 3/1/2016.
 */
public interface MovieDbCallback<T> {
    void onSuccess(T t);
    void onFailure(Throwable throwable);
}
