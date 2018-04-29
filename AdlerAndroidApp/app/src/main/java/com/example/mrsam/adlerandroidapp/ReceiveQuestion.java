package com.example.mrsam.adlerandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

public class ReceiveQuestion extends AppCompatActivity {

    protected static final String TAG = "mrsam.adlerandroidapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_question);

        //Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String questionText = intent.getStringExtra("question");
        TextView questionView = (TextView)findViewById(R.id.question_received);
        questionView.setText(questionText);
        Log.d(TAG, "onCreate called from ReceiveQuestion");
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
