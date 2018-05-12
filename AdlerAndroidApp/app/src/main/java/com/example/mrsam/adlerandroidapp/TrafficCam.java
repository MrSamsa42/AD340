package com.example.mrsam.adlerandroidapp;

public class TrafficCam {
    private String description;
    private String imageURL;
    private String type;

    public TrafficCam(String description, String imageURL, String type) {
        this.description = description;
        this.imageURL = imageURL;
        this.type = type;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {return this.type;}


}
