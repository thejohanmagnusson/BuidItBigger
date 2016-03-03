package com.udacity.gradle.builditbigger;


import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class GetJokeAsync {
    private IJokeListener jokeListener;
    private static MyApi myApiService = null;

    public GetJokeAsync(IJokeListener jokeListener){
        this.jokeListener = jokeListener;
    }

    public void execute(){
        new JokeTask().execute();
    }

    private class JokeTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            if(myApiService == null){
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                myApiService = builder.build();
            }

            try{
                return myApiService.getJoke().execute().getData();
            } catch (IOException e){
                Log.e("JokeTask:doInBackground","Error: " + e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(String joke) {
            super.onPostExecute(joke);

            jokeListener.jokeFetched(joke);
        }
    }
}
