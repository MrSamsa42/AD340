package com.example.mrsam.adlerandroidapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //enable up button
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
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
}
