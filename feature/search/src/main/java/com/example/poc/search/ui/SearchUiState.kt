package com.example.poc.search.ui

import androidx.paging.PagingData
import com.example.poc.search.data.Product
import kotlinx.coroutines.flow.Flow

data class SearchUiState(
    val productsPagingData: Flow<PagingData<Product>>? = null,
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = true,
    val error: Throwable? = null
)