package com.example.poc.server.data

// Need to create a module :datasource_databaseserver
class OrderDataSourceImpl(
    //  private val database: Database
) : OrderDataSource {

    override suspend fun getOrder(id: Long): Order {
        TODO("Not yet implemented")
    }

    override suspend fun updateOrder(order: Order): Order {
        TODO("Not yet implemented")
    }
}