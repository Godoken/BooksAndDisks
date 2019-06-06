package com.example.booksanddisks.features.products.data

import com.example.booksanddisks.features.products.domain.Product
import com.example.booksanddisks.features.products.domain.ProductsRepository
import io.reactivex.Single

class ProductsRepositoryImpl(private val productsDataSource: ProductsDataSource) : ProductsRepository {
    override fun loadProducts(): Single<List<Product>> {
        return productsDataSource.loadProducts()
    }
}