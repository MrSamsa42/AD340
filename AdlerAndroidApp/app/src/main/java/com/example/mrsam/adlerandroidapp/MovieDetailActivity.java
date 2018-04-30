package com.example.mrsam.adlerandroidapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //enable up button
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        getMovieDetailIntent();
    }

    private void getMovieDetailIntent() {
        if(getIntent().hasExtra("movieTitle")
                && getIntent().hasExtra("movieYear")
                && getIntent().hasExtra("movieDirector")
                && getIntent().hasExtra("imageURL")
                && getIntent().hasExtra("movieDescription"))
        {
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

    //Create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //what to do when option is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;

        switch(item.getItemId()) {
            case R.id.settings_menu:
                text = "Settings!";
                Toast.makeText(this, text, duration).show();
                return true;
            case R.id.search_menu:
                text = "Search!";
                Toast.makeText(this, text, duration).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
