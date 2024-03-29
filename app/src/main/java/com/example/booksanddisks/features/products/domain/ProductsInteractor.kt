package com.example.booksanddisks.features.products.domain

import io.reactivex.Single

interface ProductsInteractor {
    fun loadProducts(): Single<List<Product>>
    fun getInformation(product: Product): ArrayList<String>
}