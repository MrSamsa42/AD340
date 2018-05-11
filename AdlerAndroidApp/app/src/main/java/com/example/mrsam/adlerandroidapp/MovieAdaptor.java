package com.example.mrsam.adlerandroidapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.CustomViewHolder>{
    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdaptor(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_layout, parent, false );
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        Movie movie = movies.get(position);
        holder.movieTitle.setText(movie.title);
        holder.movieYear.setText(Integer.toString(movie.year));
    }

    @Override
    //how many items are there?
    public int getItemCount() {
        return movies.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView movieTitle;
        TextView movieYear;
        CardView parentLayout;

        public CustomViewHolder(final View view) {
            super(view);
            movieTitle = (TextView)view.findViewById(R.id.movie_title);
            movieYear = (TextView)view.findViewById(R.id.movie_year);
            parentLayout = (CardView)view.findViewById(R.id.movie_card_layout);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    Intent intent = new Intent(context, MovieDetailActivity.class);

                    intent.putExtra("movieTitle", movies.get(pos).title);
                    intent.putExtra("movieYear", Integer.toString(movies.get(pos).year) );
                    intent.putExtra("movieDirector", movies.get(pos).director);
                    intent.putExtra("imageURL", movies.get(pos).imageURL);
                    intent.putExtra("movieDescription", movies.get(pos).description);

                    context.startActivity(intent);
                }
            });
        }
    }
}
