package com.example.poc.server.domain

import com.example.poc.server.data.Order
import com.example.poc.server.data.OrderRepository

class SendOrderToKitchenUseCase(
    private val repository: OrderRepository,
    private val publishDataChangeUseCase: PublishDataChangeUseCase
) {

    suspend operator fun invoke(orderId: Long, newStatus: Order.Status) {
        val order = repository.getOrder(orderId)
        // TODO some checking and business logic
        repository.updateOrderStatus(orderId, Order.Status.PREPARING)
        publishDataChangeUseCase(orderId)
    }
}