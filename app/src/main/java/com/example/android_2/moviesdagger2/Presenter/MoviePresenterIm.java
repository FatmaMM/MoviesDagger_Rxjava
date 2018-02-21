package com.example.android_2.moviesdagger2.Presenter;

import android.util.Log;

import com.example.android_2.moviesdagger2.MainObject.Movie;
import com.example.android_2.moviesdagger2.Modal.MovieInterceptor;
import com.example.android_2.moviesdagger2.Network.MovieResponse;
import com.example.android_2.moviesdagger2.View.MoviesView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Android-2 on 1/24/2018.
 */

public class MoviePresenterIm implements MoviePresenter {

    MoviesView view;
    MovieInterceptor movieInterceptor;
    List<Movie> ms;

    public MoviePresenterIm(MovieInterceptor movieInterceptor) {
        this.movieInterceptor = movieInterceptor;
    }

    @Override
    public void setView(MoviesView view) {
        this.view = view;
        displayMovies();
    }

    @Override
    public void displayMovies() {
        movieInterceptor.fetch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        view.loadingStarted();
                        Log.e("onSub", d.isDisposed() + "\n");
                    }

                    @Override
                    public void onNext(MovieResponse movieResponse) {
                        ms = movieResponse.getResults();
                        for (Movie m : ms) {
                            Log.e("onNext", m.getTitle() + "\n");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Network error", e.getMessage());
                        view.loadingFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("Network", "done");
                        view.showMovies(ms);
                    }
                });
    }


}
