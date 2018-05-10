package com.example.mrsam.adlerandroidapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SharedPreferencesTest {

    private static final String TEST_QUESTION = "Is anybody listening?";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityRule.getActivity();
    }

    @Test
    public void testSharedPrefs(){


        //Instantiate sharedPreferences and SharedPrefs(i.e. helper class)
        SharedPreferences sharedPreferences = mActivity.getSharedPreferences(mActivity.getResources().getString(R.string.saved_question), Context.MODE_PRIVATE);
        SharedPrefs sharedPrefs = new SharedPrefs(sharedPreferences);
        sharedPrefs.putSharedPrefs(TEST_QUESTION);
        String returnedString = sharedPrefs.getSharedPrefs();
        assertEquals(TEST_QUESTION, returnedString);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}