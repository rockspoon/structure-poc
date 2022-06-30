package com.example.poc.core.data.order

interface OrderLocalServerDataSource {
    suspend fun getOrder(id: Long): Order?
    suspend fun insertOrder(user: Order): Order
}