package com.example.mrsam.adlerandroidapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TrafficCamAdaptor extends RecyclerView.Adapter<TrafficCamAdaptor.TrafficViewHolder> {
    
    private Context context;
    private ArrayList<TrafficCam> trafficCamArrayList;

    public TrafficCamAdaptor(Context context, ArrayList<TrafficCam> trafficCamArrayList){
        this.context = context;
        this.trafficCamArrayList = trafficCamArrayList;
    }

    @NonNull
    @Override
    public TrafficViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.traffic_camera_list_layout, parent, false);
        return new TrafficViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrafficViewHolder holder, int position) {
        TrafficCam trafficCam = trafficCamArrayList.get(position);
        String imageURL = trafficCam.getImageURL();
        String trafficCamDescription = trafficCam.getDescription();
        String trafficCamType = trafficCam.getType();

        holder.textViewTrafficCamDescription.setText(trafficCamDescription);
        holder.textViewTrafficCamType.setText(trafficCamType);
        Picasso.with(context).load(imageURL).fit().centerInside().into(holder.imageViewTrafficCam);
        //Glide.with(context).asBitmap().load(imageURL).into(holder.imageViewTrafficCam);
    }

    @Override
    public int getItemCount() {
        return trafficCamArrayList.size();
    }


    public class TrafficViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewTrafficCam;
        public TextView textViewTrafficCamDescription;
        public TextView textViewTrafficCamType;

        public TrafficViewHolder(View itemView) {
            super(itemView);
            imageViewTrafficCam = itemView.findViewById(R.id.traffic_camera_image);
            textViewTrafficCamDescription = itemView.findViewById(R.id.traffic_camera_description);
            textViewTrafficCamType = itemView.findViewById(R.id.traffic_camera_type);
        }
    }
}
