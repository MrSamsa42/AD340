package com.example.mrsam.adlerandroidapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.CustomViewHolder>{

    Context context;
    ArrayList<Movie> movies;

    public MovieAdaptor(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false );
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.movieTitle.setText(movie.movieTitle);
        holder.movieYear.setText(movie.year);
    }

    @Override
    //how many items are there?
    public int getItemCount() {
        return movies.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView movieTitle;
        TextView movieYear;

        public CustomViewHolder(View view) {
            super(view);
            movieTitle = (TextView)view.findViewById(R.id.movie_title);
            movieYear = (TextView)view.findViewById(R.id.movie_year);
        }
    }

}
