package com.example.booksanddisks.features.products.domain.model.bookModels

import com.example.booksanddisks.features.products.domain.model.bookModels.bookInterface.Book

class BookCook (var barCode: String,
                val title: String,
                val price: Double,
                val pageCount: Int,
                val mainPart: String) : Book {

    override fun getBookPageCount(): Int {
        return pageCount
    }

    override fun getProductTitle(): String {
        return title
    }

    override fun getProductSubtitle(): Any {
        return mainPart
    }

    override fun getProductPrice(): Double {
        return price
    }

    override fun getProductBarCode(): String {
        return barCode
    }
}