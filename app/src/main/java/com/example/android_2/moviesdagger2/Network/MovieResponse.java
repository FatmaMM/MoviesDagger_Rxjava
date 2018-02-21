package com.example.android_2.moviesdagger2.Network;

import com.example.android_2.moviesdagger2.MainObject.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Android-2 on 1/23/2018.
 */

public class MovieResponse {
    @SerializedName("results")
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }
}
