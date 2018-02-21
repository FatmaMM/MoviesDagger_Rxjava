package com.example.android_2.moviesdagger2.View;

import com.example.android_2.moviesdagger2.MainObject.Movie;

import java.util.List;

/**
 * Created by Android-2 on 1/23/2018.
 */

public interface MoviesView {
    void showMovies(List<Movie> movies);

    void loadingStarted();

    void loadingFailed(String errorMessage);

}
