package com.example.makeupapplication.domain.repository.products

import com.example.makeupapplication.domain.model.ProductsModel

interface ProductsRepository {
    suspend fun getProducts(): List<ProductsModel>

}