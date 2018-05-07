package com.example.mrsam.adlerandroidapp;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityRule.getActivity();
    }

    @Test
    public void testViewsRender(){
        View btnView = mActivity.findViewById(R.id.button);
        View etView = mActivity.findViewById(R.id.question);

        assertNotNull(btnView);
        assertNotNull(etView);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}