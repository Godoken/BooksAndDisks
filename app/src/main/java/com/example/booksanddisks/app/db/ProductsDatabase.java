package com.example.booksanddisks.app.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ProductDB.class}, version = 1, exportSchema = false)
public abstract class ProductsDatabase extends RoomDatabase {
    public abstract ProductsDao getProductsDao();
}