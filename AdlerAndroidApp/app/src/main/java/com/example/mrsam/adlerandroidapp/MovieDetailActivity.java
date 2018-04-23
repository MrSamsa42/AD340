package com.example.mrsam.adlerandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
                && getIntent().hasExtra("movieDescription")){
            String movieTitle = getIntent().getStringExtra("movieTitle");
            String movieYear = getIntent().getStringExtra("movieYear");
            String movieDirector = getIntent().getStringExtra("movieDirector");
            String movieDescription = getIntent().getStringExtra("movieDescription");

            setDetails(movieTitle, movieYear, movieDirector, movieDescription);
        }
    }

    private void setDetails(String title, String year, String director, String description) {
        TextView movieTitle = findViewById(R.id.detail_title);
        TextView movieYear = findViewById(R.id.detail_year);
        TextView movieDirector = findViewById(R.id.detail_director);
        TextView movieDescription = findViewById(R.id.detail_description);

        movieTitle.setText(title);
        movieYear.setText(year);
        movieDirector.setText(director);
        movieDescription.setText(description);
    }


}
