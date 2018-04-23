package com.example.mrsam.adlerandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        getMovieDetailIntent();

    }

    private void getMovieDetailIntent() {
        if(getIntent().hasExtra("movieTitle")
                && getIntent().hasExtra("movieYear")
                && getIntent().hasExtra("movieDirector")
                && getIntent().hasExtra("imageURL")
                && getIntent().hasExtra("movieDescription")){
            String movieTitle = getIntent().getStringExtra("movieTitle");
            String movieYear = getIntent().getStringExtra("movieYear");
            String movieDirector = getIntent().getStringExtra("movieDirector");
            String movieImageURL = getIntent().getStringExtra("imageURL");
            String movieDescription = getIntent().getStringExtra("movieDescription");

            setDetails(movieTitle, movieYear, movieDirector, movieImageURL, movieDescription);
        }
    }

    private void setDetails(String title, String year, String director, String url, String description) {

        ImageView movieImageURL = findViewById(R.id.movie_pic);
        TextView movieTitle = findViewById(R.id.detail_title);
        TextView movieYear = findViewById(R.id.detail_year);
        TextView movieDirector = findViewById(R.id.detail_director);
        TextView movieDescription = findViewById(R.id.detail_description);

        Glide.with(this).asBitmap().load(url).into(movieImageURL);

        movieTitle.setText(title);
        movieYear.setText(year);
        movieDirector.setText(director);
        movieDescription.setText(description);
    }


}
