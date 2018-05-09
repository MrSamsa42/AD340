package com.example.mrsam.adlerandroidapp;

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
        SharedPrefs sharedPrefs = new SharedPrefs(mActivity.getApplicationContext());
        sharedPrefs.putSharedPrefs(TEST_QUESTION);
        String returnedString = sharedPrefs.getSharedPrefs();
        assertEquals(TEST_QUESTION, returnedString);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}