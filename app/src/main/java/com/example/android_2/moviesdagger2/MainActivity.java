package com.example.android_2.moviesdagger2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android_2.moviesdagger2.Adapter.MoviesAdapter;
import com.example.android_2.moviesdagger2.MainObject.Movie;
import com.example.android_2.moviesdagger2.Presenter.MoviePresenter;
import com.example.android_2.moviesdagger2.View.MoviesView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MoviesView {
    ProgressDialog progressBar;
    @Inject
    MoviePresenter presenter;
    @BindView(R.id.recyclerView)
    RecyclerView moviesListing;

    private MoviesAdapter adapter;
    private List<Movie> movies = new ArrayList<>(20);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App) getApplication()).getMoComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    public void showMovies(List<Movie> movies) {
        progressBar.dismiss();
        this.movies.clear();
        this.movies.addAll(movies);
        adapter = new MoviesAdapter(movies, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        moviesListing.setLayoutManager(layoutManager);
        moviesListing.setAdapter(adapter);
    }

    @Override
    public void loadingStarted() {
        progressBar = new ProgressDialog(this);
        progressBar.setMessage("loading...");
        progressBar.show();
    }

    @Override
    public void loadingFailed(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

}
