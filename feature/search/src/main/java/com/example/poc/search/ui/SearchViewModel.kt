package com.example.poc.search.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.poc.search.data.Product
import com.example.poc.search.data.ProductRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class SearchViewModel(
    private val productRepository: ProductRepository = ProductRepository()
) : ViewModel() {

    var uiState by mutableStateOf(SearchUiState())
        private set

    init {
        // List or load initial list
//        listProducts()
        loadProducts()
    }

    private var listProductsJob: Job? = null

    fun listProducts(query: String = "") {
        listProductsJob?.cancel()
        listProductsJob = viewModelScope.launch {
            uiState = try {
                val items = productRepository.list(query)
                uiState.copy(
                    products = items,
                    isLoading = false
                )
            } catch (e: Exception) {
                uiState.copy(
                    error = e,
                    isLoading = false
                )
            }
        }
    }

    fun loadProducts(query: String = "", pageSize: Int = 10) {
        uiState = try {
            uiState.copy(
                productsPager = Pager(
                    config = PagingConfig(pageSize = pageSize),
                    pagingSourceFactory = {
                        ProductPagingSource(
                            productRepository = productRepository,
                            query = query,
                            pageSize = pageSize
                        )
                    }
                ),
                isLoading = false
            )
        } catch (e: Exception) {
            uiState.copy(
                error = e,
                isLoading = false
            )
        }
    }

    class ProductPagingSource(
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