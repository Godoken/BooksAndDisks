package com.example.booksanddisks.features.products.domain

import io.reactivex.Single

interface ProductsRepository {
    fun loadProducts(): Single<List<Product>>
}