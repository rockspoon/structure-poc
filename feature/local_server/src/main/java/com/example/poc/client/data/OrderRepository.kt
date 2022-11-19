package com.example.poc.client.data

interface OrderRepository {

    suspend fun getOrder(id: Long): Order

    /**
     * Update order.
     */
    suspend fun updateOrder(order: Order): Order

    suspend fun updateOrderStatus(orderId: Long, newStatus: Order.Status): Order

}