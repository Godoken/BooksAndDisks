package com.example.booksanddisks.features.products.domain.model.bookModels

import com.example.booksanddisks.features.products.domain.model.bookModels.bookInterface.Book

class BookCode (var barCode: String,
                val title: String,
                val price: Double,
                val pageCount: Int,
                val language: String) : Book {

    private val bookContent: String = "Программирование"

    override fun getBookPageCount(): Int {
        return pageCount
    }

    override fun getProductTitle(): String {
        return title
    }

    override fun getProductSubtitle(): Any {
        return bookContent
    }

    override fun getProductPrice(): Double {
        return price
    }

    override fun getProductBarCode(): String {
        return barCode
    }
}