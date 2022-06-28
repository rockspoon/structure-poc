package com.example.poc.server.data

class OrderRepositoryImpl(
    private val orderDataSource: OrderDataSource
) : OrderRepository {

    override suspend fun getOrder(id: Long): Order {
        return orderDataSource.getOrder(id)
    }

    override suspend fun updateOrder(order: Order): Order {
        val orderId = orderDataSource.updateOrder(order)
        return orderDataSource.getOrder(orderId)
    }

    /**
     * Update order.
     */
    override suspend fun updateOrderStatus(orderId: Long, newStatus: Order.Status): Order {
        val order = orderDataSource.getOrder(orderId)
        // some checking and business logic
        order.status = newStatus
        orderDataSource.updateOrder(order)
        return orderDataSource.getOrder(orderId)
    }


}