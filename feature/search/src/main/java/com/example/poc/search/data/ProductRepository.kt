package com.example.poc.search.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.flow.Flow

class ProductRepository(
    private val productLocalDataSourceImpl: ProductLocalDataSource = ProductLocalDataSourceImpl()
) {

    val products: Flow<List<Product>> = productLocalDataSourceImpl.products

    suspend fun list(
        query: String? = null,
        pageSize: Int? = null,
        cursorId: Long = 0
    ): List<Product> = productLocalDataSourceImpl.list(query, pageSize, cursorId)

    /**
     * Returns a [Flow] of [PagingData] for products.
     */
    fun getPagingData(
        query: String? = null,
        pageSize: Int? = null
    ): Flow<PagingData<Product>> {
        val listPageSize = pageSize ?: 10
        return Pager(
            config = PagingConfig(pageSize = listPageSize),
            pagingSourceFactory = {
                ProductPagingSource(
                    productRepository = this,
                    query = query,
                    pageSize = listPageSize
                )
            }
        ).flow
    }

    private class ProductPagingSource(
        private val productRepository: ProductRepository,
        private val query: String?,
        private val pageSize: Int = 10
    ) : PagingSource<Long, Product>() {

        override fun getRefreshKey(state: PagingState<Long, Product>): Long? {
            return state.anchorPosition?.let { anchorPosition ->
                val anchorPage = state.closestPageToPosition(anchorPosition)
                anchorPage?.prevKey?.plus(pageSize) ?: anchorPage?.nextKey?.minus(pageSize)
            }
        }

        override suspend fun load(params: LoadParams<Long>): LoadResult<Long, Product> {
            return try {
                val cursor = params.key ?: 0
                val items = productRepository.list(
                    query = query,
                    cursorId = cursor,
                    pageSize = params.loadSize
                )
                LoadResult.Page(
                    data = items,
                    prevKey = null,
                    nextKey = items.last().id
                )
            } catch (e: Exception) {
                LoadResult.Error(
                    throwable = e
                )
            }
        }
    }
}

