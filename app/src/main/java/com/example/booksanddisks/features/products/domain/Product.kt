package com.example.booksanddisks.features.products.domain

interface Product {
    fun getProductType(): String
    fun getProductTitle(): String
    fun getProductSubtitle(): Any
    fun getProductPrice(): Double
    fun getProductBarCode(): String
}