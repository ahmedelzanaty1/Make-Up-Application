package com.example.makeupapplication.domain.use_case

import com.example.makeupapplication.domain.repository.products.ProductsRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
}