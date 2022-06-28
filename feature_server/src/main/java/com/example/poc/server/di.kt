package com.example.poc.server

import androidx.room.Room
import com.example.poc.datasource.serverdatabase.Database
import com.example.poc.datasource.serverdatastore.subscription.SubscriptionSerializer.subscriptionDataStore
import com.example.poc.server.data.*
import com.example.poc.server.domain.GetOrderUseCase
import com.example.poc.server.domain.InsertOrderUseCase
import com.example.poc.server.domain.PublishDataChangeUseCase
import com.example.poc.server.domain.SendOrderToKitchenUseCase
import com.example.poc.server.service.OrderEndpoint
import com.example.poc.server.service.SubscriptionEndpoint
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

val featureServerModule = module {

    // Subscription DataStore
    single {
        androidApplication().applicationContext.subscriptionDataStore
    }

    // Database
    single {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            Database::class.java,
            "main"
        )
            .fallbackToDestructiveMigration() // TODO remove in production
            .build()
    }

    single {
        get<Database>().orderDao()
    }

    single {
        get<Database>().userDao()
    }

    // Data sources
    single<OrderDataSource> {
        OrderDataSourceImpl(
            orderDao = get()
        )
    }

    single<SubscriptionDataSource> {
        SubscriptionDataSourceImpl(
            subscriptionDataStore = get()
        )
    }

    // Repositories
    single<OrderRepository> {
        OrderRepositoryImpl(
            orderDataSource = get()
        )
    }

    single<SubscriptionRepository> {
        SubscriptionRepositoryImpl(
            subscriptionDataSource = get()
        )
    }

    // Use cases
    single {
        PublishDataChangeUseCase(
            context = androidApplication().applicationContext,
            subscriptionRepository = get()
        )
    }

    single {
        GetOrderUseCase(
            orderRepository = get()
        )
    }

    single {
        InsertOrderUseCase(
            orderRepository = get()
        )
    }

    single {
        SendOrderToKitchenUseCase(
            orderRepository = get(),
            publishDataChangeUseCase = get()
        )
    }

    // Endpoints
    single {
        OrderEndpoint(
            getOrderUseCase = get(),
            sendOrderToKitchenUseCase = get(),
            insertOrderUseCase = get()
        )
    }

    single {
        SubscriptionEndpoint(
            subscribeDataChangedUseCase = get(),
            unsubscribeDataChangedUseCase = get()
        )
    }
}

private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featureServerModule)
}

fun loadModules() {
    lazyLoadModules.value
}