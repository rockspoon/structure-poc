package com.example.poc.orders

import com.example.poc.orders.data.OrderRealmRepository
import com.example.poc.orders.data.OrderRealmRepositoryImpl
import com.example.poc.orders.ui.list.OrderListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun featureOrdersModule() = module {


    viewModelOf(::OrderListViewModel)

    singleOf(::OrderRealmRepositoryImpl) { bind<OrderRealmRepository>() }

}