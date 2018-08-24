package com.udacity.gradle.builditbigger;

public interface JokeListener {
    public void onResult(String joke);

    public void onError(String error);
}