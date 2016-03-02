package com.taurus.emin.wrapperretrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.taurus.emin.wrapperretrofitexample.api.MovieDbSingleton;
import com.taurus.emin.wrapperretrofitexample.api.callback.MovieDbCallback;
import com.taurus.emin.wrapperretrofitexample.model.Result;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MovieDbApi movieDbApi = MovieDbApi.create("847f6b4e44e8451ffa91002efdee1e62");

        MovieDbSingleton.getInstance().getMovieDbApi().getPopularMovies(new MovieDbCallback<List<Result>>() {
            @Override
            public void onSuccess(List<Result> movies) {
                Log.d("PopularMovieResult", movies.get(0).getOriginalTitle());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("Failure", throwable.getMessage());
            }
        });

        MovieDbSingleton.getInstance().getMovieDbApi().getPopularMovies(2, new MovieDbCallback<List<Result>>() {
            @Override
            public void onSuccess(List<Result> results) {
                Log.d("PopularMovieResult", results.get(0).getOriginalTitle());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("Failure", throwable.getMessage());
            }
        });

        MovieDbSingleton.getInstance().getMovieDbApi().getUpcomingMovies(1, new MovieDbCallback<List<Result>>() {
            @Override
            public void onSuccess(List<Result> results) {
                Log.d("UpcomingMovieResult", results.get(0).getOriginalTitle());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("Failure", throwable.getMessage());
            }
        });

    }
}
