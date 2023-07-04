package com.example.poc.client.domain

import com.example.poc.client.data.Order
import com.example.poc.client.data.OrderRepository

class InsertOrderUseCase(
    private val orderRepository: OrderRepository
) {

    suspend operator fun invoke(order: Order): Order {
        return orderRepository.updateOrder(order)
    }

}