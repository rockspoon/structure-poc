package com.example.poc.orders.data

import androidx.paging.PagingData
import com.example.poc.core.data.order.Order
import com.example.poc.datasource.streaming_realm.order.OrderEntity
import kotlinx.coroutines.flow.Flow

interface OrderRealmRepository {

    suspend fun observeOrders(): Flow<List<OrderEntity>>

    fun getOrders(): List<OrderEntity>

    fun getPagingData(pageSize: Int = 10): Flow<PagingData<Order>>
    suspend fun deleteOrder(order: Order)
}