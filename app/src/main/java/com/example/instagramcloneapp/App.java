package com.example.instagramcloneapp;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("x6Sqi3eiYUeIWt7cXKzS5cw3lHdkTO1Zl8yaoqN4")
                // if defined
                .clientKey("LhVSSMQFurzlyYd9ez4073VMaZjW3uQJpFvNRLGz")
                .server("https://parseapi.back4app.com/")
                .build()
        );

    }
}
