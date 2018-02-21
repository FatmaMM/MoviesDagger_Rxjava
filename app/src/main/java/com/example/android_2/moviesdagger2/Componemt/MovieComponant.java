package com.example.android_2.moviesdagger2.Componemt;

import com.example.android_2.moviesdagger2.MainActivity;
import com.example.android_2.moviesdagger2.Module.MovieModual;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Android-2 on 1/28/2018.
 */
@Singleton
@Component(modules = MovieModual.class)
public interface MovieComponant {
    void inject(MainActivity mainActivity);
}
