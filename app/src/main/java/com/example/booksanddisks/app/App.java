package com.example.booksanddisks.app;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.booksanddisks.app.db.ProductDB;
import com.example.booksanddisks.app.db.ProductsDatabase;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

        //Hard code to db
        Completable completable = new Completable() {
            @Override
            protected void subscribeActual(CompletableObserver observer) {
                App.getDataBase()
                        .getProductsDao()
                        .insertProduct(new ProductDB("barCode", "Title", "Code", 120.00,
                                "144", "Java", "Book"));

                App.getDataBase()
                        .getProductsDao()
                        .insertProduct(new ProductDB("barCode2", "TitleDisk", "Video", 130.00,
                                "DVD", "", "Disk"));

                observer.onComplete();}
        };
        CompletableObserver completableObserver = new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) { }
            @Override
            public void onComplete() { }
            @Override
            public void onError(Throwable e) { }
        };
        completable.subscribeOn(Schedulers.io()).subscribe(completableObserver);
        ////////////////// End hard code
    }
}
