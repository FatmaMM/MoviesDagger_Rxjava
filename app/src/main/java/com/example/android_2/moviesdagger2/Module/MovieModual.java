package com.example.android_2.moviesdagger2.Module;

import com.example.android_2.moviesdagger2.BuildConfig;
import com.example.android_2.moviesdagger2.Modal.InteractorImp;
import com.example.android_2.moviesdagger2.Modal.MovieInterceptor;
import com.example.android_2.moviesdagger2.Network.MovieApiservices;
import com.example.android_2.moviesdagger2.Presenter.MoviePresenter;
import com.example.android_2.moviesdagger2.Presenter.MoviePresenterIm;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android-2 on 1/28/2018.
 */
@Module
public class MovieModual {
    @Provides
    Retrofit retrofit() {
        return new Retrofit
                .Builder()
                .baseUrl(BuildConfig.TMDB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    @Provides
    MovieApiservices tmdbWebService(Retrofit retrofit) {
        return retrofit.create(MovieApiservices.class);
    }

    @Provides
    MovieInterceptor provideMovieInteractor(MovieApiservices tmdbWebService) {
        return new InteractorImp(tmdbWebService);
    }

    @Provides
    MoviePresenter provideMoviePresenter(InteractorImp it) {
        return new MoviePresenterIm(it);
    }


}
