package com.example.booksanddisks.features.products.domain.model.diskModels.diskInterfaces

import com.example.booksanddisks.features.products.domain.Product

interface DiskCD : Product {

    override fun getProductType(): String {
        return "diskCD"
    }
}