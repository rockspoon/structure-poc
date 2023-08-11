package com.example.poc.orders.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.poc.core.data.order.Order
import com.example.poc.core.data.order.OrderRealmDataSource
import com.example.poc.datasource.streaming_realm.order.OrderEntity
import kotlinx.coroutines.flow.Flow

internal class OrderRealmRepositoryImpl(
    private val orderRealmDataSource: OrderRealmDataSource
) : OrderRealmRepository {

    override suspend fun observeOrders(): Flow<List<OrderEntity>> =
        orderRealmDataSource.observeOrders()

    override fun getOrders(): List<OrderEntity> = orderRealmDataSource.getOrders()

    /**
     * Returns a [Flow] of [PagingData] for products.
     */
    override fun getPagingData(
        pageSize: Int
    ): Flow<PagingData<Order>> {
        return Pager(
            config = PagingConfig(pageSize = pageSize),
            pagingSourceFactory = {
                ProductPagingSource(
                    ordersRepository = this,
                    pageSize = pageSize
                )
            }
        ).flow
    }

    override suspend fun deleteOrder(order: Order) {
        order.id?.let {
            orderRealmDataSource.delete(it)
        }
    }

    // Putting nested and private avoid exposing the paging source implementation.
    private class ProductPagingSource(
        private val ordersRepository: OrderRealmRepository,
        private val pageSize: Int = 10
    ) : PagingSource<Int, Order>() {

        override fun getRefreshKey(state: PagingState<Int, Order>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                val anchorPage = state.closestPageToPosition(anchorPosition)
                anchorPage?.prevKey?.plus(pageSize) ?: anchorPage?.nextKey?.minus(pageSize)
            }
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Order> {
            return try {
                val cursor = params.key ?: 0
                val start = cursor * params.loadSize
                val items: List<Order> =
                    ordersRepository.getOrders().subList(start, start + params.loadSize)
                        .map { it.toModel() }
                LoadResult.Page(
                    data = items,
                    prevKey = null,
                    nextKey = cursor + 1
                )
            } catch (e: Exception) {
                LoadResult.Error(
                    throwable = e
                )
            }
        }
    }

}

fun OrderEntity.toModel() = Order(
    id = id?.toHexString(),
    name = name ?: "",
    items = items.map {
        Order.Item(
            productId = it.productId.timestamp.toLong(),
            quantity = it.quantity,
            name = it.name
        )
    }
)