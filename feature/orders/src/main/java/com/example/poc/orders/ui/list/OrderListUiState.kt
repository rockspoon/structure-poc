package com.example.poc.orders.ui.list

import androidx.paging.PagingData
import com.example.poc.core.data.order.Order
import com.example.poc.datasource.streaming_realm.order.OrderEntity
import kotlinx.coroutines.flow.Flow

data class OrderListUiState(
    val orders: List<OrderEntity> = emptyList(),
    val ordersPaging: Flow<PagingData<Order>>? = null,
    val isLoading: Boolean = true,
    val error: Throwable? = null
)