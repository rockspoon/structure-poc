package com.example.poc.core.data.product

import kotlinx.coroutines.flow.Flow

/**
 * A data source that handles syncing operations between a local and remote databases automatically
 * using Realm Atlas Sync.
 */
internal interface ProductRealmDataSource {

    /**
     * Get an pr.
     */
    suspend fun getProduct(id: Long): Product

    /**
     * Observe an product.
     */
    fun observeProduct(id: Long): Flow<Product>

    /**
     * Update or insert an product in the data source.
     */
    suspend fun saveProduct(model: Product): Product

    class ProductNotFoundException(id: Long) : IllegalArgumentException("Product with ID $id was not found in the data source.")
}
