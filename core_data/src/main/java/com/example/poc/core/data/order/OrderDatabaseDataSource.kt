package com.example.poc.core.data.order

import kotlinx.coroutines.flow.Flow

// Data source classes are the first line in contact with outside models. This models are often
// imported directly into the project and we have zero control over their modelling, like Google
// Places API resources. Here we should convert to Flow that emits our models, so think data sources
// like adapters for data or wrapper for data accessors. Data sources are here instead of
// :datasource modules. The reason is that we not always will have a :datasource module, most of the
// time the :datasource module is an external library, this classes serves as representations of
// them. The :datasource modules also can't access our models.
internal interface OrderDatabaseDataSource {
    suspend fun getOrder(id: Long): Order?
    fun observeOrder(id: Long): Flow<Order?>
    suspend fun insertOrder(user: Order): Order
}
