package com.example.booksanddisks.features.products.data

import com.example.booksanddisks.features.products.domain.Product
import io.reactivex.Single

interface ProductsDataSource {
    fun loadProducts(): Single<List<Product>>
}