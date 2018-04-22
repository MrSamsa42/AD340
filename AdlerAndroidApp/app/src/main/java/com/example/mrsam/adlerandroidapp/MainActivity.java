package com.example.mrsam.adlerandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String TAG = "mrsam.adlerandroidapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
