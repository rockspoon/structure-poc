package com.example.poc.search.ui.detail

import com.example.poc.search.data.Product

data class ProductUiState(
    val product: Product? = null,
    val isLoading: Boolean = true,
    val error: Throwable? = null
)