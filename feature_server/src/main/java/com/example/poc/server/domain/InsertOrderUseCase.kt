package com.example.poc.server.domain

import com.example.poc.server.data.Order
import com.example.poc.server.data.OrderRepository

class InsertOrderUseCase(
    private val orderRepository: OrderRepository
) {

    suspend operator fun invoke(order: Order): Order {
        return orderRepository.updateOrder(order)
    }

}