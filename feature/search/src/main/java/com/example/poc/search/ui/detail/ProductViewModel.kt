package com.example.poc.search.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.search.data.Product
import com.example.poc.search.data.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class ProductViewModel(
    savedStateHandle: SavedStateHandle,
    productRepository: ProductRepository
) : ViewModel() {

    var uiState by mutableStateOf(ProductUiState())
        private set

    private val productId: Long = checkNotNull(savedStateHandle["productId"])

    private val product: Flow<Product> = productRepository.get(productId)

    init {
        product.onEach {
            uiState = uiState.copy(product = it)
        }.launchIn(viewModelScope)
    }
}