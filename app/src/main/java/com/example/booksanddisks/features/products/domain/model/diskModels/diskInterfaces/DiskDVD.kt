package com.example.booksanddisks.features.products.domain.model.diskModels.diskInterfaces

import com.example.booksanddisks.features.products.domain.Product

interface DiskDVD : Product {

    override fun getProductType(): String {
        return "diskDVD"
    }
}