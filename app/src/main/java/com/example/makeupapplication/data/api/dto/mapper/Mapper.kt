package com.example.makeupapplication.data.api.dto.mapper

import com.example.makeupapplication.data.api.dto.ProductsDtoItem
import com.example.makeupapplication.domain.model.ProductsModel

fun ProductsDtoItem.toProductsModel(): ProductsModel {
    return ProductsModel(
        id = id ?: 0,
        name = name ?: "",
        price = price ?: "",
        productType = productType ?: "",
        imageUrl = imageLink ?: ""
    )
}