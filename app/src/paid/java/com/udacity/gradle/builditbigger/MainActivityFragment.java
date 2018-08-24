package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ProgressBar progressBar;
    Button button;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar = view.findViewById(R.id.progress_bar);
        button = view.findViewById(R.id.button_tell_joke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });
        return view;
    }

    public void tellJoke() {
        startProgressBar();
        new JokesEndPointAsyncTask(getActivity()).execute();
    }

    public void startProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void stopProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
