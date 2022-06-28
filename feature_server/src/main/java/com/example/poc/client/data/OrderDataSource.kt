package com.example.poc.client.data

// The implementation will use Database
interface OrderDataSource {

    suspend fun getOrder(id: Long): Order

    suspend fun updateOrder(order: Order): Long

}