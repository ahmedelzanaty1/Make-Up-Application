package com.example.makeupapplication.presentation.screens.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makeupapplication.common.Resource
import com.example.makeupapplication.domain.model.ProductsModel
import com.example.makeupapplication.domain.use_case.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _productsState = MutableStateFlow<Resource<List<ProductsModel>>>(Resource.Loading())
    val productsState: StateFlow<Resource<List<ProductsModel>>> = _productsState.asStateFlow()
    init {
        getProducts()
    }
    private fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase().collect { result ->
                _productsState.value = result
            }
        }
    }
}
