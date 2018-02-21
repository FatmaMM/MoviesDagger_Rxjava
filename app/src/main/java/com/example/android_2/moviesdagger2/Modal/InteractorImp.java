package com.example.android_2.moviesdagger2.Modal;

import com.example.android_2.moviesdagger2.BuildConfig;
import com.example.android_2.moviesdagger2.Network.MovieApiservices;
import com.example.android_2.moviesdagger2.Network.MovieResponse;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by Android-2 on 1/31/2018.
 */

public class InteractorImp implements MovieInterceptor {
    MovieApiservices apiservices;

    @Inject
    public InteractorImp(MovieApiservices apiservices) {
        this.apiservices = apiservices;
    }

    @Override
    public Observable<MovieResponse> fetch() {
        return apiservices.getPopularMovies(BuildConfig.TMDB_API_KEY);
    }
}
