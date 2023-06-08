package com.example.poc.core.data.order

import com.example.poc.datasource.remoteclientapi.RemoteClientApiClient
import com.example.poc.datasource.remoteclientapi.order.OrderResource

internal class OrderRemoteServerDataSourceImpl(
    private val apiClient: RemoteClientApiClient
) : OrderRemoteServerDataSource {

    // Probably put a try and catch here and convert the remote exception to an app exception
    override suspend fun getOrder(id: Long): Order? {
        return apiClient.order.get(id).toModel()
    }

    override suspend fun insertOrder(order: Order): Order {
        return apiClient.order.insert(order.toResource()).toModel()
    }

    private fun OrderResource.toModel() =
        Order(
            id = id.toString()
        )

    private fun Order.toResource() =
        OrderResource(
            id = id?.toLong()
        )
}