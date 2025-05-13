package com.example.makeupapplication.data.api

import com.example.makeupapplication.data.api.dto.ProductsDtoItem
import retrofit2.http.GET

interface ApiManager {
    @GET("products.json")
    suspend fun getProducts():List<ProductsDtoItem>
}