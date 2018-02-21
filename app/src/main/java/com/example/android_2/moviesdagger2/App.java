package com.example.android_2.moviesdagger2;

import android.app.Application;

import com.example.android_2.moviesdagger2.Componemt.DaggerMovieComponant;
import com.example.android_2.moviesdagger2.Componemt.MovieComponant;
import com.example.android_2.moviesdagger2.Module.MovieModual;

/**
 * Created by Android-2 on 1/23/2018.
 */

public class App extends Application {

    App app;
    MovieComponant moC;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        moC = DaggerMovieComponant.builder().movieModual(new MovieModual()).build();
    }

    public App app() {
        return app;
    }

    public MovieComponant getMoComponent() {
        return moC;
    }
}
