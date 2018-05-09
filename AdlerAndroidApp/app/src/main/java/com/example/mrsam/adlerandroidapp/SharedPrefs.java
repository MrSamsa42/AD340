package com.example.mrsam.adlerandroidapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;


public class SharedPrefs{
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPrefs(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.saved_question), Context.MODE_PRIVATE);
    }

    public void putSharedPrefs(String str){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getResources().getString(R.string.question_key), str);
        editor.commit();
    }

    public String getSharedPrefs(){
        String str = sharedPreferences.getString(context.getResources().getString(R.string.question_key),context.getResources().getString(R.string.default_question));
        return str;
    }
}
