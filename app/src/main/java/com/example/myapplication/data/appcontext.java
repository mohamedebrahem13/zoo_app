package com.example.myapplication.data;

import android.app.Application;
import android.content.Context;

public class appcontext extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        appcontext.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return appcontext.context;
    }
}
