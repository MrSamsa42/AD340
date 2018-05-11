package com.example.mrsam.adlerandroidapp;

public class TrafficCam {
    private String description;
    private String imageURL;

    public TrafficCam(String description, String imageURL) {
        this.description = description;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getDescription() {
        return this.description;
    }


}
