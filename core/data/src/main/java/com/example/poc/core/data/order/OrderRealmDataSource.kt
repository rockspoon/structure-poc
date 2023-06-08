package com.example.poc.core.data.order

import kotlinx.coroutines.flow.Flow

/**
 * A data source that handles syncing operations between a local and remote databases automatically
 * using Realm Atlas Sync.
 */
internal interface OrderRealmDataSource {

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

    class OrderNotFoundException(id: String) : IllegalArgumentException("Order with ID $id was not found in the data source.")
}
