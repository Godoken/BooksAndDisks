package com.example.booksanddisks.features.products.data

import com.example.booksanddisks.app.db.ProductDB
import com.example.booksanddisks.app.db.ProductsDatabase
import com.example.booksanddisks.features.products.domain.Product
import com.example.booksanddisks.features.products.domain.model.bookModels.BookCode
import com.example.booksanddisks.features.products.domain.model.bookModels.BookCook
import com.example.booksanddisks.features.products.domain.model.bookModels.BookMagic
import com.example.booksanddisks.features.products.domain.model.diskModels.DiskCDImpl
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ProductsDataSourceImpl(private val database: ProductsDatabase) : ProductsDataSource {
    override fun loadProducts(): Single<List<Product>> {
        return database.productsDao.allProducts
                .subscribeOn(Schedulers.io())
                .toObservable()
                .flatMap { list: MutableList<ProductDB> ->  Observable.fromIterable(list)}
                .map { product: ProductDB -> convertToModel(product)}
                .toList()
    }

    private fun convertToModel(product: ProductDB): Product {
        val productModel: Product
        if (product.typeOfProduct == "Book"){
            if (product.subtitle == "Code"){
                productModel = BookCode(product.barCode, product.title,
                        product.price.toDouble(), product.pageCountOrDiskType.toInt(),
                        product.importantAboutBook)
            } else {
                if (product.subtitle == "Cook") {
                    productModel = BookCook(product.barCode, product.title,
                            product.price.toDouble(), product.pageCountOrDiskType.toInt(),
                            product.importantAboutBook)
                } else {
                    productModel = BookMagic(product.barCode, product.title,
                            product.price.toDouble(), product.pageCountOrDiskType.toInt(),
                            product.importantAboutBook.toInt())
                }
            }
        } else {

            if (product.pageCountOrDiskType == "CD"){
                productModel = DiskCDImpl(product.barCode, product.title,
                        product.price.toDouble(), product.subtitle, product.pageCountOrDiskType)
            } else {
                productModel = DiskCDImpl(product.barCode, product.title,
                        product.price.toDouble(), product.subtitle, product.pageCountOrDiskType)
            }
        }
        return productModel
    }
}