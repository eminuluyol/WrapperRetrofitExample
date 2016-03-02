package com.taurus.emin.wrapperretrofitexample.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.taurus.emin.wrapperretrofitexample.api.callback.MovieDbCallback;
import com.taurus.emin.wrapperretrofitexample.model.PopularMovieResult;
import com.taurus.emin.wrapperretrofitexample.model.Result;
import com.taurus.emin.wrapperretrofitexample.model.UpcomingMovieResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Emin on 3/1/2016.
 */
public class MovieDbApi {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    private final MovieDbService movieDbService;
    private final String apiKey;

    private MovieDbApi(MovieDbService movieDbService, String apiKey) {
        this.movieDbService = movieDbService;
        this.apiKey = apiKey;
    }

    public static MovieDbApi create(String apiKey) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MovieDbService movieDbService = retrofit.create(MovieDbService.class);

        return new MovieDbApi(movieDbService, apiKey);
    }

    public void getPopularMovies(final MovieDbCallback<List<Result>> callback) {
        Call<PopularMovieResult> call = movieDbService.getPopularMovies(apiKey);
        call.enqueue(new Callback<PopularMovieResult>() {
            @Override
            public void onResponse(Call<PopularMovieResult> call, Response<PopularMovieResult> response) {
                callback.onSuccess(response.body().getResults());
            }

            @Override
            public void onFailure(Call<PopularMovieResult> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public void getPopularMovies(int page, final MovieDbCallback<List<Result>> callback) {
        Call<PopularMovieResult> call = movieDbService.getPopularMovies(apiKey, page);
        call.enqueue(new Callback<PopularMovieResult>() {
            @Override
            public void onResponse(Call<PopularMovieResult> call, Response<PopularMovieResult> response) {
                callback.onSuccess(response.body().getResults());
            }

            @Override
            public void onFailure(Call<PopularMovieResult> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public void getUpcomingMovies(int page, final MovieDbCallback<List<Result>> callback) {
        Call<UpcomingMovieResult> call = movieDbService.getUpcomingMovies(apiKey,page);
        call.enqueue(new Callback<UpcomingMovieResult>() {
            @Override
            public void onResponse(Call<UpcomingMovieResult> call, Response<UpcomingMovieResult> response) {
                callback.onSuccess(response.body().getResults());
            }

            @Override
            public void onFailure(Call<UpcomingMovieResult> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
