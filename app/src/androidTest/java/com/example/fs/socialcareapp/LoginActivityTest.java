package com.example.fs.socialcareapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by Danny Monroy on 02/04/2017.
 */
public class LoginActivityTest {

    //Test Rule
    @Rule
    public ActivityTestRule<LoginActivity> tLoginActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    //Reference to the Activity
    public LoginActivity mLoginActivity = null;

    Instrumentation.ActivityMonitor monitor =getInstrumentation().addMonitor(InfoActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mLoginActivity = tLoginActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOnButtonClick() throws Exception {
       assertNotNull(mLoginActivity.findViewById(R.id.text_info));

        onView(withId(R.id.text_info)).perform(click());

        Activity infoActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 10000);

        assertNotNull(infoActivity);

        infoActivity.finish();
    }

    @After
    public void tearDown() throws Exception {

        mLoginActivity = null;
    }

}