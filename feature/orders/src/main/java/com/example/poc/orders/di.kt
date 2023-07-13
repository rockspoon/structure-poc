package com.example.poc.orders

import com.example.poc.orders.data.OrderRealmRepository
import com.example.poc.orders.data.OrderRealmRepositoryImpl
import com.example.poc.orders.data.ProductLocalDataSource
import com.example.poc.orders.data.ProductLocalDataSourceImpl
import com.example.poc.orders.data.ProductRepository
import com.example.poc.orders.ui.detail.ProductViewModel
import com.example.poc.orders.ui.list.OrderListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun featureOrdersModule() = module {

    singleOf<ProductLocalDataSource>(::ProductLocalDataSourceImpl)

    singleOf(::ProductRepository)

    viewModelOf(::OrderListViewModel)

    viewModelOf(::ProductViewModel)

    singleOf(::OrderRealmRepositoryImpl) { bind<OrderRealmRepository>() }

}