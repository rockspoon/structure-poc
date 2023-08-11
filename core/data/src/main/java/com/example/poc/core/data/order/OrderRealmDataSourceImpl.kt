package com.example.poc.core.data.order

import com.example.poc.datasource.streaming_realm.order.OrderEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mongodb.kbson.ObjectId
import timber.log.Timber

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

    override suspend fun observeOrders(): Flow<List<OrderEntity>> =
        database.query<OrderEntity>().asFlow().map { it.list }

    override fun getOrders(): List<OrderEntity> =
        database.query(OrderEntity::class, "_id != null").find()

    override suspend fun delete(id: String) {
        database.write {
            val order = database.query(OrderEntity::class, "_id == $0", ObjectId(id)).first().find()
            order?.let {
                findLatest(it)?.also {
                    delete(it)
                }
            }
        }
    }

    private fun OrderEntity.toModel() = Order(
        id = id?.toHexString(),
        name = name ?: "",
        items = items.map {
            Order.Item(
                id = it.id?.toHexString(),
                productId = it.productId.timestamp.toLong(),
                quantity = it.quantity,
                name = it.name
            )
        }
    )

    private fun Order.toEntity() = OrderEntity().apply {
        this.id = this@toEntity.id?.let { ObjectId(it) } ?: ObjectId()
        this.name = this@toEntity.name
        this.items = this@toEntity.items.map { orderItem ->
            OrderEntity.Item().apply {
                id = orderItem.id?.let { ObjectId(it) } ?: ObjectId()
                productId = ObjectId(orderItem.productId)
                quantity = orderItem.quantity
                name = orderItem.name
            }
        }.toRealmList()
    }
}