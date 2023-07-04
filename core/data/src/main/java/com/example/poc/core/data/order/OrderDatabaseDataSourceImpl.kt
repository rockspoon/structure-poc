package com.example.poc.core.data.order

import com.example.poc.datasource.database.Database
import com.example.poc.datasource.database.order.OrderEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Using data sources directly is forbidden with the keyword `internal` so to do not overpass our
// sync logic between database and remote data as written in the repository. The interfaces can
// still be mocked for testing though.
internal class OrderDatabaseDataSourceImpl(
    private val database: Database
) : OrderDatabaseDataSource {

    override suspend fun getOrder(id: Long): Order {
        return database.orderDao().get(id).toModel()
    }

    override fun observeOrder(id: Long): Flow<Order> {
        // Add here a call to Database that returns a Flow so we can observe changes to the "order"
        // database table. Notice that we just need to map the entity to model because Room has
        // first class support for coroutines. In case a library do not return coroutines Flow
        // directly, we would have to create a flow using the `callbackFlow { }` builder to map
        // their callbacks to flow emissions.
        return database.orderDao().observe(id).map {
            it.toModel()
        }
    }

    override suspend fun saveOrder(
        order: Order
    ): Order {
        val entity = order.toEntity()
        val id = database.orderDao().insert(entity)
        return database.orderDao().get(id).toModel()
    }

    private fun OrderEntity.toModel() =
        Order(
            id = id.toString()
        )

    private fun Order.toEntity() =
        OrderEntity(
            id = id?.toLong()
        )
}