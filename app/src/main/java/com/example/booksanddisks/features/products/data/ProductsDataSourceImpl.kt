package com.example.booksanddisks.features.products.data

import com.example.booksanddisks.app.App
import com.example.booksanddisks.app.db.ProductsDatabase
import com.example.booksanddisks.features.products.domain.Product
import io.reactivex.Single

class ProductsDataSourceImpl(private val database: ProductsDatabase) : ProductsDataSource {
    override fun loadProducts(): Single<List<Product>> {
        return database.productsDao.allProducts
    }
}