package com.example.poc.core.data.product

import kotlinx.coroutines.flow.Flow

interface ProductLocalDataSource {

    val products: Flow<List<Product>>

    fun get(productId: Long): Flow<Product>

    suspend fun list(
        query: String? = null,
        pageSize: Int? = null,
        cursorId: Long = 0
    ): List<Product>
}