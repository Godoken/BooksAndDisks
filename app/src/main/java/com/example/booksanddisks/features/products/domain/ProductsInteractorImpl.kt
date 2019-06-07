package com.example.booksanddisks.features.products.domain

import io.reactivex.Single

class ProductsInteractorImpl(private val productsRepository: ProductsRepository) : ProductsInteractor {
    override fun getInformation(product: Product): ArrayList<String> {
        return arrayListOf<String>(product.getProductTitle(),
                product.getProductSubtitle().toString(),
                product.getProductPrice().toString(),
                product.getProductBarCode(),
                product.getProductType())
    }

    override fun loadProducts(): Single<List<Product>> {
        return productsRepository.loadProducts()
                .map { list: List<Product> -> sortProducts(list)}
}

    private fun sortProducts(list: List<Product>): List<Product> {
        val sortedList: MutableList<Product> = ArrayList<Product>()
        val bookList: MutableList<Product> = ArrayList<Product>()
        val diskList: MutableList<Product> = ArrayList<Product>()

        list.forEach { product: Product -> if (product.getProductType() == "Book") {
            bookList.add(product)
        } else {
            diskList.add(product)
        }}

        sortedList.addAll(bookList)
        sortedList.addAll(diskList)

        return sortedList
    }
    }
