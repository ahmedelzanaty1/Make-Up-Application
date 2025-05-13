package com.example.makeupapplication.data.repository

import com.example.makeupapplication.data.api.ApiManager
import com.example.makeupapplication.data.api.dto.ProductsDto
import com.example.makeupapplication.data.api.dto.mapper.toProductsModel
import com.example.makeupapplication.domain.model.ProductsModel
import com.example.makeupapplication.domain.repository.products.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiManager
) : ProductsRepository {
    override suspend fun getProducts(): List<ProductsModel> {
        return apiService.getProducts().map {it.toProductsModel()}

    }
}