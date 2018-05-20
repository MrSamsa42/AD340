package com.example.mrsam.adlerandroidapp;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected static final String TAG = "mrsam.adlerandroidapp";
    private SharedPrefs sharedPrefs;
    private SharedPreferences sharedPreferences;
    private String savedQuestion;

    private static final int ERROR_DIALOG_REQUEST = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context = getApplicationContext();

        //Instantiate sharedPreferences and SharedPrefs(i.e. helper class)
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.saved_question), Context.MODE_PRIVATE);
        sharedPrefs = new SharedPrefs(sharedPreferences);

        isServicesOK();

        DrawerLayout drawer;
        ActionBarDrawerToggle toggle;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        EditText questionView = (EditText) findViewById(R.id.question);
        savedQuestion = sharedPrefs.getSharedPrefs();
        questionView.setText(savedQuestion);

        //for debugging
        Log.d(TAG, "onCreate called from Main Activity");
    }

    //need this because main implements NavigationView.OnNavigationItemSelectedListener
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        Context context = getApplicationContext();

        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();


        switch(id){
            case R.id.movie_link:
                intent = new Intent(this, MovieViewActivity.class);
                break;
            case R.id.about_link:
                intent = new Intent(this, AboutActivity.class);
                break;
            case R.id.traffic_camera_link:
                if(isConnected) {
                    intent = new Intent(this, TrafficActivity.class);
                } else {
                    Toast.makeText(this, "You are not connected to the internet!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.map_link:
                intent = new Intent(this, MapActivity.class);
                Log.d(TAG, "onNavigationItemSelected: Map selected");
                break;
        }
        if(intent != null) {
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //close drawer when back button pressed
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    public void onSendQuestion(View view){
        EditText questionView = (EditText) findViewById(R.id.question);
        String questionText = questionView.getText().toString();
        String invalidInput = "";
        Intent intent;

        if(!questionText.isEmpty()){   //&& !questionText.matches("-?\\d+(\\.\\d+)?")){

            sharedPrefs.putSharedPrefs(questionText);

            intent = new Intent(this, ReceiveQuestion.class);
            intent.putExtra("question", questionText);
            startActivity(intent);
        } else {
            invalidInput = "Invalid input -- try again!";
            Toast.makeText(this, invalidInput, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validateInput(String str){
        return !str.isEmpty();
    }

    public boolean isServicesOK() {
        Log.d(TAG, "isServicesOK: checking google services version.");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if (available == ConnectionResult.SUCCESS) {
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        } else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //e.g. wrong version
            Log.d(TAG, "isServicesOK: an error occurred but we can fix it.");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "You can't make map requests, you loser.", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    public void onButton3Click(View view){
        CharSequence text = "Cheers!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }

    public void onButton4Click(View view){
        CharSequence text = "Prost!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }

    public void onButton5Click(View view){
        CharSequence text = "à votre santé!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }

    public void onMovieButtonClick(View view){
        Intent intent = new Intent(this, MovieViewActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called from Main Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called from Main Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called from Main Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called from Main Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called from Main Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart called from Main Activity");
    }
}
