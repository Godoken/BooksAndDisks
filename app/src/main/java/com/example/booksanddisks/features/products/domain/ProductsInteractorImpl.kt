package com.example.booksanddisks.features.products.domain

import io.reactivex.Single

class ProductsInteractorImpl(private val productsRepository: ProductsRepository) : ProductsInteractor {
    override fun loadProducts(): Single<List<Product>> {
        return productsRepository.loadProducts()
    }
}