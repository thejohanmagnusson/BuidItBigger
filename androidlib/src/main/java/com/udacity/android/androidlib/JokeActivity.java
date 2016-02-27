package com.udacity.android.androidlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke";

    private TextView mJokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_joke);

        if(savedInstanceState == null){
            String joke = getIntent().getStringExtra(JOKE_KEY);

            if(!joke.isEmpty())
                mJokeText.setText(joke);
            else
                mJokeText.setText("Can´t remember the joke right now, sorry...");
        }
    }
}
