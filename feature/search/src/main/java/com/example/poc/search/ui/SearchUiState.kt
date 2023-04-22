package com.example.poc.search.ui

import androidx.paging.Pager
import com.example.poc.search.data.Product

data class SearchUiState(
    val productsPager: Pager<Long, Product>? = null,
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = true,
    val error: Throwable? = null
)