package com.example.mrsam.adlerandroidapp;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mrsam.adlerandroidapp.SharedPrefs;

@RunWith(MockitoJUnitRunner.class)

public class SharedPrefsUnitTest {

    @Mock
    SharedPreferences mockSharedPreferences;

    @Mock
    SharedPreferences.Editor mockEditor;

    private SharedPrefs mockSharedPrefs;

    static String TEST_STRING = "Is anybody listening?";

    @Before
    public void initializeMockSharedPrefs() {
        mockSharedPrefs = createMockSharedPrefs();
    }

    @Test
    public void testReadSaveSharedPrefs() {
        boolean success = mockSharedPrefs.putSharedPrefs(TEST_STRING);

        assertTrue(success);

        assertEquals(TEST_STRING, mockSharedPrefs.getSharedPrefs());
    }

    private SharedPrefs createMockSharedPrefs () {
        // Mocking reading the SharedPreferences as if mMockSharedPreferences was previously written
        // correctly.
        when(mockSharedPreferences.getString(eq(mockSharedPrefs.QUESTION_KEY), anyString()))
                .thenReturn(TEST_STRING);

        // Mocking a successful commit.
        when(mockEditor.commit()).thenReturn(true);

        // Return the MockEditor when requesting it.
        when(mockSharedPreferences.edit()).thenReturn(mockEditor);

        return new SharedPrefs(mockSharedPreferences);
    }


}
