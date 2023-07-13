package com.example.poc.orders.ui.detail

import com.example.poc.orders.data.Product

data class ProductUiState(
    val product: Product? = null,
    val isLoading: Boolean = true,
    val error: Throwable? = null
)