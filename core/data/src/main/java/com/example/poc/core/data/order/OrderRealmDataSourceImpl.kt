package com.example.poc.core.data.order

import com.example.poc.datasource.streaming_realm.order.OrderEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.toRealmList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mongodb.kbson.ObjectId

internal class OrderRealmDataSourceImpl(
    private val database: Realm
) : OrderRealmDataSource {

    override suspend fun getOrder(id: String): Order {
        return database.query(OrderEntity::class, "_id == $0", ObjectId(id)).first().find()
            ?.toModel()
            ?: throw OrderRealmDataSource.OrderNotFoundException(id)
    }

    override fun observeOrder(id: String): Flow<Order> {
        return database.query(OrderEntity::class, "_id == $0", ObjectId(id)).first().asFlow().map {
            it.obj?.toModel() ?: throw OrderRealmDataSource.OrderNotFoundException(id)
        }
    }

    override suspend fun saveOrder(
        model: Order
    ): Order {
        val entity = model.toEntity()
        val result = database.writeBlocking {
            copyToRealm(entity)
        }
        return result.toModel()
    }

    private fun OrderEntity.toModel() = Order(
        id = id?.toHexString(),
        name = name ?: "",
        items = items.map {
            Order.Item(
                productId = it.productId.asNumber().longValue(),
                quantity = it.quantity
            )
        }
    )

    private fun Order.toEntity() = OrderEntity().apply {
        this.id = this@toEntity.id?.let { ObjectId(it) } ?: ObjectId()
        this.name = this@toEntity.name
        this.items = this@toEntity.items.map {orderItem ->
            OrderEntity.Item().apply {
                id = orderItem.id?.let { ObjectId(it) } ?: ObjectId()
                productId = ObjectId(orderItem.productId)
                quantity = orderItem.quantity
            }
        }.toRealmList()
    }
}