package com.example.android_2.moviesdagger2.Presenter;

import com.example.android_2.moviesdagger2.View.MoviesView;

/**
 * Created by Android-2 on 1/24/2018.
 */

public interface MoviePresenter {
    void displayMovies();
    void setView(MoviesView view);
}
