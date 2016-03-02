package com.taurus.emin.wrapperretrofitexample;

import android.app.Application;

import com.taurus.emin.wrapperretrofitexample.api.MovieDbSingleton;

/**
 * Created by Emin on 3/1/2016.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MovieDbSingleton.init("847f6b4e44e8451ffa91002efdee1e62");
    }
}
