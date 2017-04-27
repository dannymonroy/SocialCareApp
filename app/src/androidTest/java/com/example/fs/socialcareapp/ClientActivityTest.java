package com.example.fs.socialcareapp;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by Danny Monroy on 27/04/2017.
 */
public class ClientActivityTest {

    public ActivityTestRule<ClientActivity> tClientActivityTestRule = new ActivityTestRule<>(ClientActivity.class);

    public ClientActivity mClientActivity = null;

    Instrumentation.ActivityMonitor monitor =getInstrumentation().addMonitor(InfoActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mClientActivity = tClientActivityTestRule.getActivity();


    }

    @Test
    public void onCreate() throws Exception {
        assertNotNull(mClientActivity.findViewById(R.id.text_info));

        onView(withId(R.id.text_info)).perform(click());
    }

    @After
    public void tearDown() throws Exception {

    }



}