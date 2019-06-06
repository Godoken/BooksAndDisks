package com.example.booksanddisks.app;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.booksanddisks.app.db.ProductsDatabase;

public class App extends Application {

    private static ProductsDatabase dataBase;
    private static Context context;

    public static ProductsDatabase getDataBase() {
        return dataBase;
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dataBase = Room.databaseBuilder(getApplicationContext(), ProductsDatabase.class, "app-database").build();
        context = getApplicationContext();
    }
}
