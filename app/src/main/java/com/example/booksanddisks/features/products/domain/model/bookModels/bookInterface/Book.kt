package com.example.booksanddisks.features.products.domain.model.bookModels.bookInterface

import com.example.booksanddisks.features.products.domain.Product

interface Book : Product {
    fun getBookPageCount(): Int

    override fun getProductType(): String {
        return "book"
    }
}