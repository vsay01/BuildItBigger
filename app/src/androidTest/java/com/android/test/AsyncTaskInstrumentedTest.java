package com.android.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.JokeListener;
import com.udacity.gradle.builditbigger.JokesEndPointAsyncTask;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import app.udacity.jokeactivity.MainActivity;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

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
    public void testAsyncTaskReturnNonEmptyString() {
        final CountDownLatch signal = new CountDownLatch(1);
        try {
            JokesEndPointAsyncTask jokesEndPointAsyncTask = new JokesEndPointAsyncTask(activityRule.getActivity());
            jokesEndPointAsyncTask.setJokeListener(new JokeListener() {
                @Override
                public void onResult(String joke) {
                    assertTrue(joke.length() > 0);
                    signal.countDown();
                }

                @Override
                public void onError(String error) {
                    assertFalse(error.length() > 0);
                    signal.countDown();
                }
            });
            jokesEndPointAsyncTask.execute();
            signal.await();
        } catch (InterruptedException e) {

        }
    }
}
