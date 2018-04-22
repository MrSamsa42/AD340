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
        if(getIntent().hasExtra("movieTitle")){
            String movieTitle = getIntent().getStringExtra("movieTitle");
            setDetails(movieTitle);
        }
    }

    private void setDetails(String title) {
        TextView name = findViewById(R.id.detail_title);
        name.setText(title);
    }


}
