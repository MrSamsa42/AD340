package com.example.mrsam.adlerandroidapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;


public class SharedPrefs{

    //key for saving values in Shared Preferences.  Putting this here as a constant so that I do not
    //have to access Strings resource later.
    static final String QUESTION_KEY = "question";

    private SharedPreferences sharedPreferences;

    public SharedPrefs(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
    }

    //
    public boolean putSharedPrefs(String str){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(QUESTION_KEY, str);

        return editor.commit();
    }

    public String getSharedPrefs(){
        return sharedPreferences.getString(QUESTION_KEY, "whatever");
    }
}
