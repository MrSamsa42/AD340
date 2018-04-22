package com.example.mrsam.adlerandroidapp;

public class Movie {
    public String title;
    public int year;
    public String director;
    public String imageURL;
    public String description;

    Movie(String title, int year, String director, String imageURL, String description){
        this.title = title;
        this.director = director;
        this.imageURL = imageURL;
        this.description = description;
    }
}
