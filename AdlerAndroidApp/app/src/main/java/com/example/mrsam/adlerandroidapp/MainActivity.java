package com.example.mrsam.adlerandroidapp;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    protected static final String TAG = "mrsam.adlerandroidapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setChecked(true);
                    //TODO: handle navigation
                    //Closing drawer on item click
                    drawer.closeDrawers();
                    return true;
                }
            }
        );

        Log.d(TAG, "onCreate called from Main Activity");
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

    public void onSendQuestion(View view){
        EditText questionView = (EditText) findViewById(R.id.question);
        String questionText = questionView.getText().toString();

        Intent intent = new Intent(this, ReceiveQuestion.class);
        intent.putExtra("question", questionText);
        startActivity(intent);
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

}
