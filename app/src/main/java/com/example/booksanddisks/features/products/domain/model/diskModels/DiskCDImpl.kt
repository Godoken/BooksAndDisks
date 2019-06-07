package com.example.booksanddisks.features.products.domain.model.diskModels

import com.example.booksanddisks.features.products.domain.model.diskModels.diskInterfaces.DiskCD

class DiskCDImpl (var barCode: String,
                  val title: String,
                  val price: Double,
                  val content: String,
                  val diskType: String) : DiskCD {
    override fun getProductBarCode(): String {
        return barCode
    }

    override fun getProductPrice(): Double {
        return price
    }

    override fun getProductTitle(): String {
        return title
    }

    override fun getProductSubtitle(): String {
        return content
    }
}