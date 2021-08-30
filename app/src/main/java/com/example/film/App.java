package com.example.film;

import android.app.Application;

import androidx.room.Room;

import com.example.film.frameworks.room.AppDatabase;

public class App extends Application {

    private static AppDatabase appDatabase;

    public void onCreate() {
        super.onCreate();
        appDatabase = Room
                .databaseBuilder(this,AppDatabase.class,"database")
                .allowMainThreadQueries()
                .build();
    }
    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
