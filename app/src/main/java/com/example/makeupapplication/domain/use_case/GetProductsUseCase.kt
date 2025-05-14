package com.example.makeupapplication.domain.use_case

import com.example.makeupapplication.common.Resource
import com.example.makeupapplication.domain.model.ProductsModel
import com.example.makeupapplication.domain.repository.products.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<ProductsModel>>> = flow {
        try {
            emit(Resource.Loading())
            val products = productsRepository.getProducts()
            emit(Resource.Success(products))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An error occurred"))
        }

    }
}