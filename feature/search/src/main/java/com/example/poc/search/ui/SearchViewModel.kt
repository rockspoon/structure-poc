package com.example.poc.search.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.poc.search.data.ProductRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class SearchViewModel(
    private val productRepository: ProductRepository = ProductRepository()
) : ViewModel() {

    var uiState by mutableStateOf(SearchUiState())
        private set

    init {
        // List or load initial list
//        listProducts()
        loadProducts()
    }

    private var listProductsJob: Job? = null

    fun listProducts(query: String = "") {
        listProductsJob?.cancel()
        listProductsJob = viewModelScope.launch {
            uiState = try {
                val items = productRepository.list(query)
                uiState.copy(
                    products = items,
                    isLoading = false
                )
            } catch (e: Exception) {
                uiState.copy(
                    error = e,
                    isLoading = false
                )
            }
        }
    }

    fun loadProducts(query: String = "", pageSize: Int = 10) {
        uiState = try {
            uiState.copy(
                productsPagingData = productRepository.getPagingData(
                    query = query,
                    pageSize = pageSize
                ).cachedIn(viewModelScope),
                isLoading = false
            )
        } catch (e: Exception) {
            uiState.copy(
                error = e,
                isLoading = false
            )
        }
    }
}