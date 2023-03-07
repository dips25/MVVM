package com.example.mvvm;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class MVVM extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(getApplicationContext());
    }
}
