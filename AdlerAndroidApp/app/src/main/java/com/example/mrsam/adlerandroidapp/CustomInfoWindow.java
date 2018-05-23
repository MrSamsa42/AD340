package com.example.mrsam.adlerandroidapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Callback;

public class CustomInfoWindow implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public CustomInfoWindow(Context ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        //return null;
        View view = ( (Activity)context).getLayoutInflater().inflate(R.layout.custom_info_window, null );

        TextView camName = view.findViewById(R.id.info_window_cam_description);
        ImageView camPic = view.findViewById(R.id.info_window_cam_pic);

        camName.setText(marker.getTitle());

        InfoWindowData camData = (InfoWindowData)marker.getTag();
        //TrafficCam camData = (TrafficCam)marker.getTag();

        String imageURL = camData.getImageURL();


        Picasso.with(view.getContext()).load(imageURL).error(R.mipmap.ic_launcher).resize(450, 330).into(camPic, new MarkerCallback(marker));
        //Glide.with(context).asBitmap().load(imageURL).into(camPic);

        return view;
    }

    // Callback is an interface from Picasso:
    static class MarkerCallback implements Callback {
        Marker marker = null;

        MarkerCallback(Marker marker)
        {
            this.marker = marker;
        }

        @Override
        public void onError() {}

        @Override
        public void onSuccess()
        {
            if (marker == null)
            {
                return;
            }

            if (!marker.isInfoWindowShown())
            {
                return;
            }

            // If Info Window is showing, then refresh it's contents:

            marker.hideInfoWindow(); // Calling only showInfoWindow() throws an error
            marker.showInfoWindow();
        }
    }
}
