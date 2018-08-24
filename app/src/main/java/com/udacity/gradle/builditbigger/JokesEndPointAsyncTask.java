package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import static app.udacity.jokeactivity.MainActivity.JOKE_EXTRA_KEY;

public class JokesEndPointAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private JokeListener jokeListener;

    public JokesEndPointAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getJokeDetail();
        } catch (IOException e) {
            if (jokeListener != null) {
                jokeListener.onError("");
            }
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(final String result) {
        if (jokeListener != null) {
            jokeListener.onResult(result);
        }
        if (context != null) {
            ((MainActivityFragment) ((MainActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment)).stopProgressBar();
            Intent intent = new Intent(context, app.udacity.jokeactivity.MainActivity.class);
            intent.putExtra(JOKE_EXTRA_KEY, result);
            context.startActivity(intent);
        }
    }

    public void setJokeListener(JokeListener jokeListener) {
        this.jokeListener = jokeListener;
    }
}