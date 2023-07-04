package com.example.poc.core.data.product

import com.example.poc.datasource.streaming_realm.product.ProductEntity
import io.realm.kotlin.Realm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mongodb.kbson.ObjectId

internal class ProductRealmDataSourceImpl(
    private val database: Realm
) : ProductRealmDataSource {

    override suspend fun getProduct(id: Long): Product {
        return database.query(ProductEntity::class, "_id == $0", ObjectId(id)).first().find()
            ?.toModel()
            ?: throw ProductRealmDataSource.ProductNotFoundException(id)
    }

    override fun observeProduct(id: Long): Flow<Product> {
        return database.query(ProductEntity::class, "_id == $0", ObjectId(id)).first().asFlow()
            .map {
                it.obj?.toModel() ?: throw ProductRealmDataSource.ProductNotFoundException(id)
            }
    }

    override suspend fun saveProduct(
        model: Product
    ): Product {
        val entity = model.toEntity()
        val result = database.writeBlocking {
            copyToRealm(entity)
        }
        return result.toModel()
    }

    private fun ProductEntity.toModel() = Product(
        id = id?.timestamp?.toLong(),
        title = title,
        description = description ?: "",
    )

    private fun Product.toEntity() = ProductEntity().apply {
        this.id = this@toEntity.id?.let { ObjectId(it) } ?: ObjectId()
        this.title = this@toEntity.title
    }
}