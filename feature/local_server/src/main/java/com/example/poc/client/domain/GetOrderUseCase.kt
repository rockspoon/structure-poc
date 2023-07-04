package com.example.poc.client.domain

import com.example.poc.client.data.Order
import com.example.poc.client.data.OrderRepository

class GetOrderUseCase(
    private val orderRepository: OrderRepository
) {

    suspend operator fun invoke(orderId: Long): Order {
        return orderRepository.getOrder(orderId)
    }

}