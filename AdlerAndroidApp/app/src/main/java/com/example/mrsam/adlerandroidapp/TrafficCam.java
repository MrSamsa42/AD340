package com.example.mrsam.adlerandroidapp;

import com.google.android.gms.maps.model.LatLng;

public class TrafficCam {
    private String description;
    private String imageURL;
    private String type;
    //private LatLng coordinates;

    public TrafficCam(String description, String imageURL, String type) {
        this.description = description;
        this.imageURL = imageURL;
        this.type = type;
        //this.coordinates = new LatLng(latitude, longitude);
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {return this.type;}


}
