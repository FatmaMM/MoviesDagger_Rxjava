package com.example.android_2.moviesdagger2.Network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android-2 on 1/23/2018.
 */

public interface MovieApiservices {
    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/popular")
     Observable<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);
}
