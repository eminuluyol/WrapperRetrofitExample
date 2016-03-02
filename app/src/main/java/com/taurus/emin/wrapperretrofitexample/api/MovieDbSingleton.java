package com.taurus.emin.wrapperretrofitexample.api;

/**
 * Created by Emin on 3/1/2016.
 */
public class MovieDbSingleton {
    private static MovieDbApi movieDbApi;
    private static MovieDbSingleton instance;
    private String apiKey;

    private MovieDbSingleton() {
    }

    public static void init(String apiKey) {
        movieDbApi = MovieDbApi.create(apiKey);
    }

    public static MovieDbSingleton getInstance() {
        if (instance == null) {
            instance = new MovieDbSingleton();
        }
        return instance;
    }

    public MovieDbApi getMovieDbApi() {
        return movieDbApi;
    }
}
