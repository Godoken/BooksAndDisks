package com.example.booksanddisks.app.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.booksanddisks.features.products.domain.Product;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ProductsDao {

    @Query("SELECT * FROM productImpl")
    Single<List<Product>> getAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllProducts(List<Product> productList);

    /*@Query("SELECT * FROM guest WHERE eventId = :eventId")
    Single<List<Guest>> getAllGuestsByEventId(int eventId);*/
}
