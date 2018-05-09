package com.example.mrsam.adlerandroidapp;

import android.app.Activity;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidationTest {

    @Test
    public void validateInput() {
        MainActivity mActivity = new MainActivity();
        String positiveTestPhrase = "This should work";
        String negativeTestPhase = ""; //...and this should not work

        assertTrue(mActivity.validateInput(positiveTestPhrase));
        assertFalse(mActivity.validateInput(negativeTestPhase));
    }
}