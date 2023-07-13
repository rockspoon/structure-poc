package com.example.poc.orders.ui.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.core.data.order.Order
import com.example.poc.orders.data.OrderRealmRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber

internal class OrderListViewModel(
    private val orderRepository: OrderRealmRepository,
) : ViewModel() {

    var uiState by mutableStateOf(OrderListUiState())
        private set

    init {
        loadProducts()
    }

    fun deleteItem(orderItem: Order) {
        viewModelScope.launch {
            try {
                orderRepository.deleteOrder(orderItem)
            } catch (ex: Exception) {
                Timber.tag("OrderListViewModel").e(ex)
                uiState = uiState.copy(
                    error = ex
                )
            }
        }
    }

    /**
     * Updates the UI state with a paging data of products for lazy loading.
     */
    private fun loadProducts(pageSize: Int = 2) {
        /*uiState = try {
            uiState.copy(
                ordersPaging = orderRepository.getPagingData(pageSize).cachedIn(viewModelScope)
            )
        } catch (ex: Exception) {
            uiState.copy(
                error = ex
            )
        }*/
        viewModelScope.launch {
            orderRepository.observeOrders()
                .catch {
                    uiState = uiState.copy(
                        error = it,
                        isLoading = false
                    )
                }.collect {
                    uiState = uiState.copy(
                        orders = it,
                        isLoading = false
                    )
                }
        }
    }
}