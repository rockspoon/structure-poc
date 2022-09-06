package com.example.poc.client.domain

import com.example.poc.client.data.Order
import com.example.poc.client.data.OrderRepository

class UpdateOrderStatusUseCase(
    private val orderRepository: OrderRepository,
    private val publishDataChangeUseCase: PublishDataChangeUseCase
) {

    suspend operator fun invoke(orderId: Long, newStatus: Order.Status) {
        val order = orderRepository.getOrder(orderId)
        // TODO some checking and business logic
        order.status = newStatus
        orderRepository.updateOrder(order)
        publishDataChangeUseCase(orderId)
    }

}