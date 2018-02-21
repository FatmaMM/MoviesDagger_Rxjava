package com.example.android_2.moviesdagger2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_2.moviesdagger2.MainObject.Movie;
import com.example.android_2.moviesdagger2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android-2 on 1/23/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.mViewHolder> {
    List<Movie> list;

    private Context context;
    final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342/";

    /**
     * Movies Adapter constructor
     *
     * @param movies  list
     * @param context
     */
    @Inject
    public MoviesAdapter(List<Movie> movies, Context context) {
        this.context = context;
        this.list = movies;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        mViewHolder viewHolder = new mViewHolder(view);
        return viewHolder;
    }

    /**
     * Bind a View that displays the data at the specified position in the data set.
     *
     * @param position The position of the item within the adapter's data set of the item whose view we want.
     * @param holder   view to reuse, if possible.
     */

    @Override
    public void onBindViewHolder(final mViewHolder holder, final int position) {
        holder.movie = list.get(position);
        /**picasso library to load the image from uri path to image view
         */
        Picasso.with(context)
                .load(IMAGE_URL_BASE_PATH + holder.movie.getPosterPath())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageView);
        holder.name.setText(holder.movie.getTitle());
        holder.rate.setText(String.valueOf(holder.movie.getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class mViewHolder extends RecyclerView.ViewHolder {
        /**
         * Defines cast recycler view row elements.
         */
        public Movie movie;
        @BindView(R.id.item_image)
        ImageView imageView;
        @BindView(R.id.item_name)
        TextView name;
        @BindView(R.id.item_ranting)
        TextView rate;

        public mViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
