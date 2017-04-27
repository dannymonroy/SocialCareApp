package com.example.fs.socialcareapp;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Danny Monroy on 27/04/2017.
 */
public class ListActivityTest {

    //Test Rule
    @Rule
    public ActivityTestRule<ListActivity> tListActivityTestRule = new ActivityTestRule<>(ListActivity.class);

    //Reference to the Activity
    public ListActivity mListActivity = null;


    @Before
    public void setUp() throws Exception {
        mListActivity = tListActivityTestRule.getActivity();
    }

    @Test
    public void onCreate() throws Exception {

        assertNotNull(mListActivity.findViewById(R.id.rec_list));

    }




}