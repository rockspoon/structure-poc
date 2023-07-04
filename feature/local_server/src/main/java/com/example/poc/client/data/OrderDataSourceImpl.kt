package com.example.poc.client.data

import com.example.poc.datasource.serverdatabase.order.OrderDao
import com.example.poc.datasource.serverdatabase.order.OrderEntity

class OrderDataSourceImpl(
    private val orderDao: OrderDao
) : OrderDataSource {

    override suspend fun getOrder(id: Long): Order {
        return orderDao.get(id).toModel()
    }

    override suspend fun updateOrder(order: Order): Long {
        return orderDao.insert(order.toEntity())
    }

    private fun OrderEntity.toModel() =
        Order(
            id = id,
            status = Order.Status.valueOf(this.status.name)
        )

    private fun Order.toEntity() =
        OrderEntity(
            id = this.id,
            status = OrderEntity.Status.valueOf(this.status.name)
        )
}