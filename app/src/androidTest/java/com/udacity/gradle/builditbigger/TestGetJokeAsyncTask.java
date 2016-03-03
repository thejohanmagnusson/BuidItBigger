package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestGetJokeAsyncTask extends AndroidTestCase implements IJokeListener{
    CountDownLatch latch;
    String joke = null;

    public void testGetJokeAsyncTask(){
        try{
            latch = new CountDownLatch(1);
            new GetJokeAsync(this).execute();
            latch.await(5, TimeUnit.SECONDS);

            assertNotNull("Fetching joke failed, joke is null", joke);

        }catch (Exception e){
            fail("Exception while fetching joke: " + e.getMessage());
        }
    }

    @Override
    public void jokeFetched(String joke) {
        this.joke = joke;
        latch.countDown();
    }
}
