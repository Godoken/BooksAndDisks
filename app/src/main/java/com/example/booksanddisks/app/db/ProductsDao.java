package com.example.booksanddisks.app.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ProductsDao {

    @Query("SELECT * FROM productDB")
    Single<List<ProductDB>> getAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllProducts(List<ProductDB> productList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(ProductDB product);
}
