package com.example.poc.client.data

class OrderRepository(
    private val orderDataSource: OrderDataSource
) {

     suspend fun getOrder(id: Long): Order {
        return orderDataSource.getOrder(id)
    }

     suspend fun updateOrder(order: Order): Order {
        val orderId = orderDataSource.updateOrder(order)
        return orderDataSource.getOrder(orderId)
    }

}