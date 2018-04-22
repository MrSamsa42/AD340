package com.example.mrsam.adlerandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MovieViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_view);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Movie> movieList = new ArrayList<>();

        Movie exampleMov1 = new Movie("FakeMovie1", "1980");
        movieList.add(exampleMov1);

        Movie exampleMov2 = new Movie("FakeMovie2", "1981");
        movieList.add(exampleMov2);

        Movie exampleMov3 = new Movie("FakeMovie3", "1982");
        movieList.add(exampleMov3);

        Movie exampleMov4 = new Movie("FakeMovie4", "1989");
        movieList.add(exampleMov4);

        MovieAdaptor movieAdaptor = new MovieAdaptor(getApplicationContext(), movieList);

        recyclerView.setAdapter(movieAdaptor);

    }


}
