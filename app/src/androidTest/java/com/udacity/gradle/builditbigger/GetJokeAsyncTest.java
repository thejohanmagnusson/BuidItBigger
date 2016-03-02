package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GetJokeAsyncTest extends AndroidTestCase implements IJokeListener {
    CountDownLatch latch;
    GetJokeAsync getJokeAsync;
    String joke = "";

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        getJokeAsync = new GetJokeAsync(this);
        latch = new CountDownLatch(1);
    }

    @UiThreadTest
    public void execute() throws InterruptedException {
        getJokeAsync.execute();
        latch.await(5, TimeUnit.SECONDS);
        assertTrue("Joke fetched ok", joke != "");
    }

    @Override
    public void jokeFetched(String joke) {
        this.joke = joke;
        //release
        latch.countDown();
    }
}
