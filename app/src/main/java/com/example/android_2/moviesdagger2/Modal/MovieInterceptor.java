package com.example.android_2.moviesdagger2.Modal;

import com.example.android_2.moviesdagger2.Network.MovieResponse;

import io.reactivex.Observable;

/**
 * Created by Android-2 on 1/31/2018.
 */

public interface MovieInterceptor {
    Observable<MovieResponse> fetch();
}
