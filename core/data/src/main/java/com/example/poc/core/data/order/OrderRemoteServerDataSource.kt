package com.example.poc.core.data.order

interface OrderRemoteServerDataSource {
    suspend fun getOrder(id: Long): Order?
    suspend fun insertOrder(order: Order): Order

    class SeverUnavailableException : RuntimeException("Sever is unavailable")
}