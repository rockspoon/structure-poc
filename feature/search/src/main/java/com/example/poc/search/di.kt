package com.example.poc.search

import com.example.poc.search.data.ProductLocalDataSource
import com.example.poc.search.data.ProductLocalDataSourceImpl
import com.example.poc.search.data.ProductRepository
import com.example.poc.search.ui.detail.ProductViewModel
import com.example.poc.search.ui.list.ProductListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun featureSearchModule() = module {

    singleOf<ProductLocalDataSource>(::ProductLocalDataSourceImpl)

    singleOf(::ProductRepository)

    viewModelOf(::ProductListViewModel)

    viewModelOf(::ProductViewModel)
}

private val lazyLoadModule = lazy {
    GlobalContext.loadKoinModules(featureSearchModule())
}

fun loadModule() {
    lazyLoadModule.value
}