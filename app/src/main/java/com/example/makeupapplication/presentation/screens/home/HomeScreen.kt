package com.example.makeupapplication.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.makeupapplication.common.Resource
import com.example.makeupapplication.presentation.screens.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.productsState.collectAsState()

    when (val result = state) {
        is Resource.Loading -> {
            CircularProgressIndicator()
        }
        is Resource.Success -> {
            LazyColumn {
                items(result.data?.size ?: 0) { product ->
                    Text(text = result.data!![product].name)
                }
            }
        }

        is Resource.Error -> {
            Log.d("TAG", "HomeScreen: ${result.message}")
            Text(text = result.message ?: "An error occurred")
        }
    }
}