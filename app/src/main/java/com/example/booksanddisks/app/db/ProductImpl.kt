package com.example.booksanddisks.app.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.booksanddisks.features.products.domain.Product

@Entity
class ProductImpl (@field:PrimaryKey var barCode: String,
                   val title: String,
                   val price: Double,
                   val pageCount: Int,
                   val language: String) : Product {
    override fun getProductType(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProductBarCode(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProductPrice(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProductTitle(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProductSubtitle(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}