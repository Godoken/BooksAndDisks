package com.example.booksanddisks.app.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ProductDB (@field:PrimaryKey var barCode: String,
                 val title: String,
                 val subtitle: String,
                 val price: Double,
                 val pageCountOrDiskType: String,
                 val importantAboutBook: String,
                 val typeOfProduct: String)