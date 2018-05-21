package com.example.mrsam.adlerandroidapp;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TrafficActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private TrafficCamAdaptor trafficCamAdaptor;
    private ArrayList<TrafficCam> trafficCamArrayList;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);

        recyclerView = findViewById(R.id.traffic_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        trafficCamArrayList = new ArrayList<TrafficCam>();
        trafficCamAdaptor = new TrafficCamAdaptor(TrafficActivity.this, trafficCamArrayList);
        recyclerView.setAdapter(trafficCamAdaptor);

        requestQueue = Volley.newRequestQueue(this);
        parseJSON();

        //Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //enable up button
        ActionBar actionBar = getSupportActionBar();
            if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
    }
}


    private void parseJSON() {
        String url = "https://web6.seattle.gov/Travelers/api/Map/Data?zoomId=17&type=2";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Features");

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject feature = jsonArray.getJSONObject(i);

                                JSONArray cameras = feature.getJSONArray("Cameras");
                                for(int j = 0; j < cameras.length(); j++){
                                    JSONObject camera = cameras.getJSONObject(j);
                                    String type = camera.getString("Type");
                                    String imageURL = camera.getString("ImageUrl");
                                    if(type.equals("sdot")){
                                        imageURL = "http://www.seattle.gov/trafficcams/images/" + imageURL;
                                    } else {
                                        imageURL = "http://images.wsdot.wa.gov/nw/" + imageURL;
                                    }
                                    String camDescription = camera.getString("Description");
                                    trafficCamArrayList.add(new TrafficCam(camDescription, imageURL, type));
                                }
                            }

                            trafficCamAdaptor.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();;
            }
        });
        requestQueue.add(request);
    }

    //Create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        MenuItem menuItem = menu.findItem(R.id.search_menu);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String searchInput = newText.toLowerCase();
        ArrayList<TrafficCam> filteredList = new ArrayList<TrafficCam>();

        for(int i = 0; i < trafficCamArrayList.size(); i++) {
            TrafficCam cam = trafficCamArrayList.get(i);
            if(cam.getDescription().toLowerCase().contains(searchInput) ||
             cam.getType().toLowerCase().contains(searchInput)){
                filteredList.add(cam);
            }
        }
        trafficCamAdaptor.updateTrafficCamList(filteredList);
        return true;
    }
}
