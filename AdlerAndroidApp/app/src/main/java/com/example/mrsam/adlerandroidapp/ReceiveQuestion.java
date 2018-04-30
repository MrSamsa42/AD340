package com.example.mrsam.adlerandroidapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiveQuestion extends AppCompatActivity {

    protected static final String TAG = "mrsam.adlerandroidapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_question);

        //Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //enable up button
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String questionText = intent.getStringExtra("question");
        TextView questionView = (TextView)findViewById(R.id.question_received);
        questionView.setText(questionText);
        Log.d(TAG, "onCreate called from ReceiveQuestion");
    }

    //Create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        CharSequence text = "Settings!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called from ReceiveQuestion");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called from ReceiveQuestion");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called from ReceiveQuestion");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called from ReceiveQuestion");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called from ReceiveQuestion");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart called from ReceiveQuestion");
    }
}
