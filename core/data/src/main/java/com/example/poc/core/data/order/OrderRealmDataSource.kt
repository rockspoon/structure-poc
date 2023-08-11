package com.example.poc.core.data.order

import com.example.poc.datasource.streaming_realm.order.OrderEntity
import kotlinx.coroutines.flow.Flow

/**
 * A data source that handles syncing operations between a local and remote databases automatically
 * using Realm Atlas Sync.
 */
interface OrderRealmDataSource {

    /**
     * Get an order.
     */
    suspend fun getOrder(id: String): Order

    /**
     * Observe an order.
     */
    fun observeOrder(id: String): Flow<Order>

    /**
     * Update or insert an order in the data source.
     */
    suspend fun saveOrder(model: Order): Order

    suspend fun observeOrders(): Flow<List<OrderEntity>>

    fun getOrders(): List<OrderEntity>
    suspend fun delete(id: String)

    class OrderNotFoundException(id: String) : IllegalArgumentException("Order with ID $id was not found in the data source.")
}
