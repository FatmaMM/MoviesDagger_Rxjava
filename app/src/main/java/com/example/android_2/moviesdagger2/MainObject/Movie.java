package com.example.android_2.moviesdagger2.MainObject;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Android-2 on 1/23/2018.
 */

@Entity(tableName = "favoritemovie")
public class Movie {

    @ColumnInfo(name = "posterpath")
    @SerializedName("poster_path")
    private String posterPath;

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private String overview;

    @ColumnInfo(name = "year")
    @SerializedName("release_date")
    private String releaseDate;

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private Integer id;

    @ColumnInfo(name = "language")
    @SerializedName("original_language")
    private String originalLanguage;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @ColumnInfo(name = "backposterpath")
    @SerializedName("backdrop_path")
    private String backdropPath;

    @ColumnInfo(name = "rating")
    @SerializedName("vote_average")
    private Double voteAverage;

    public Movie() {

    }

    public Movie(String posterPath, String overview, String releaseDate, Integer id
            , String originalLanguage, String title, Double voteAverage) {
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.id = id;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.backdropPath = backdropPath;
        this.voteAverage = voteAverage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
