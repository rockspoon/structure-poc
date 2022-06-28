package com.example.poc.server.domain

import com.example.poc.server.data.Order
import com.example.poc.server.data.OrderRepository

class GetOrderUseCase(
    private val orderRepository: OrderRepository
) {

    suspend operator fun invoke(orderId: Long): Order {
        return orderRepository.getOrder(orderId)
    }

}