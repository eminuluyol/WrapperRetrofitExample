package com.taurus.emin.wrapperretrofitexample.api;

import com.taurus.emin.wrapperretrofitexample.model.PopularMovieResult;
import com.taurus.emin.wrapperretrofitexample.model.UpcomingMovieResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Emin on 3/1/2016.
 */
public interface MovieDbService {
    @GET("movie/popular")
    Call<PopularMovieResult> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<PopularMovieResult> getPopularMovies(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/upcoming")
    Call<UpcomingMovieResult> getUpcomingMovies(@Query("api_key") String apiKey, @Query("page") int page);
}
