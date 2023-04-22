package com.example.poc.search

import com.example.poc.search.data.ProductLocalDataSource
import com.example.poc.search.data.ProductLocalDataSourceImpl
import com.example.poc.search.data.ProductRepository
import com.example.poc.search.ui.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val featureSearchModules = module {

    singleOf<ProductLocalDataSource>(::ProductLocalDataSourceImpl)

    singleOf<ProductRepository>(::ProductRepository)

    viewModelOf(::SearchViewModel)
}

private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featureSearchModules)
}

fun loadModules() {
    lazyLoadModules.value
}