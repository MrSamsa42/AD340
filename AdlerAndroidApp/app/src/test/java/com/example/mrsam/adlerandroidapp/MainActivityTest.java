package com.example.mrsam.adlerandroidapp;

import android.app.Activity;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void validateInput() {
        MainActivity mActivity = new MainActivity();
        String positiveTestPhrase = "This should work";
        String negativeTestPhase = "";

        assertTrue(mActivity.validateInput(positiveTestPhrase));
        assertFalse(mActivity.validateInput(negativeTestPhase));
    }
}