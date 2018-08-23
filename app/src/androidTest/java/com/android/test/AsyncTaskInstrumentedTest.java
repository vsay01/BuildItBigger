package com.android.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.JokesEndPointAsyncTask;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import app.udacity.jokeactivity.MainActivity;

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(
            MainActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False to customize the intent

    @Test
    public void testAsyncTaskReturnNonEmptyString() throws InterruptedException, ExecutionException, TimeoutException {
        JokesEndPointAsyncTask jokesEndPointAsyncTask = new JokesEndPointAsyncTask(activityRule.getActivity());
        jokesEndPointAsyncTask.execute();
        String joke = jokesEndPointAsyncTask.get(5, TimeUnit.SECONDS);
        Assert.assertNotEquals(0, joke.length());
    }
}
