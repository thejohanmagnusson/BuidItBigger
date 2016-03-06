package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.udacity.android.androidlib.JokeActivity;


public class MainActivity extends ActionBarActivity implements OnFetchJokeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFetchJoke() {
        new GetJokeAsync(new OnGceJokeListener() {
            @Override
            public void onJokeFetched(String joke) {
                MainActivityFragment fragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

                if(fragment != null)
                    fragment.hideProgressbar();

                if(joke == null)
                    joke = getString(R.string.no_joke);

                Intent intent = new Intent(getApplicationContext(), JokeActivity.class).putExtra(JokeActivity.JOKE_KEY, joke);
                startActivity(intent);
            }
        }).execute();
    }
}
