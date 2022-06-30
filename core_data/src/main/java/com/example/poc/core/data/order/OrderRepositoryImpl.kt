package com.example.poc.core.data.order

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


// By having the REST API and database calls in data sources, I can, for example, just mock my
// remote data source returning whatever I want and I will not need to make calls to remote server
// and I still can test my logic implementation regarding the database synchronization, like in the
// insert method.
class OrderRepositoryImpl(
    private val orderDatabaseDataSource: OrderDatabaseDataSource,
    private val orderRemoteServerDataSource: OrderRemoteServerDataSource,
    private val orderLocalServerDataSource: OrderLocalServerDataSource
) : OrderRepository {

    override suspend fun getOrder(id: Long): Order? {

        // Always get order from database as it's our source of truth. If the data in the server
        // changes, a push notification should with the sync message should be send to the device
        // so it pull a new order and insert it in the database.
        return orderDatabaseDataSource.getOrder(id)
    }

    /**
     * Returns a coroutine Flow<Order?> that observes changes in the
     * [androidx.room.Database].
     */
    override fun observeOrder(id: Long): Flow<Order?> {
        return orderDatabaseDataSource.observeOrder(id)
    }

    /**
     * Insert a Order first in the remote sever, than in the device database, returning the entity.
     */
    override suspend fun insertOrder(order: Order): Order {

        // Insert in the server, get the response...
        val remoteOrder = orderRemoteServerDataSource.insertOrder(order)

        // ...then insert in our database before returning it, preserving local database as single
        // source of truth.
        return orderDatabaseDataSource.insertOrder(remoteOrder)
    }

    /**
     * A sync function that can be used by the sync service.
     */
    // TODO This sync function is calling the remote server. I need to implement the business logic
    //      that choose between remote and local server, as well as make sure there is no conflict.
    // Need also a rule to enter contingency mode
    //  Better return a Flow so we can emit a retrying object Loading style stating
    //  that it's going to retry and success. Be careful to do not disrespect transparency in
    // coroutine exception handling.
   override suspend fun syncOrder(orderId: Long): Order {

        // Fetch in the server, get the response...
        val order: Order = try {
            orderRemoteServerDataSource.getOrder(orderId)
                ?: throw OrderRepository.OrderRemoteNotFoundException(orderId)
        } catch (e: OrderRemoteServerDataSource.SeverUnavailableException) {
            // TODO Schedule to retry in 3 seconds

            orderLocalServerDataSource.getOrder(orderId)
                ?: throw OrderRepository.OrderRemoteNotFoundException(orderId)
        } catch (e: Exception) {
            throw e
        }

        // ...then insert in our database before returning it, preserving local database as single
        // source of truth.
        return orderDatabaseDataSource.insertOrder(order)
    }
}