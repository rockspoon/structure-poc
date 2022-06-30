package com.example.poc.core.data.order

import kotlinx.coroutines.flow.Flow

interface OrderRepository {

    suspend fun getOrder(id: Long): Order?

    fun observeOrder(id: Long) : Flow<Order?>

    suspend fun insertOrder(order: Order): Order

    suspend fun syncOrder(orderId: Long) : Order?

    class OrderRemoteNotFoundException(id: Long) : RuntimeException("Order with $id was not found in the remote sever.")
}