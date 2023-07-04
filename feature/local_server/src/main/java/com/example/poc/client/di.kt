package com.example.poc.client

import androidx.room.Room
import androidx.work.WorkManager
import com.example.poc.datasource.serverdatabase.Database
import com.example.poc.datasource.serverdatastore.subscription.SubscriptionSerializer.subscriptionDataStore
import com.example.poc.client.data.*
import com.example.poc.client.domain.GetOrderUseCase
import com.example.poc.client.domain.InsertOrderUseCase
import com.example.poc.client.domain.PublishDataChangeUseCase
import com.example.poc.client.domain.SendOrderToKitchenUseCase
import com.example.poc.client.service.OrderEndpoint
import com.example.poc.client.service.SubscriptionEndpoint
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

val featureServerModule = module {

    // Subscription DataStore
    single {
        androidApplication().subscriptionDataStore
    }

    // Database
    single {
        Room.databaseBuilder(
            androidApplication(),
            Database::class.java,
            "main"
        )
            .fallbackToDestructiveMigration() // TODO remove in production
            .build()
    }

    factory {
        get<Database>().orderDao()
    }

    factory {
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
    single {
        OrderRepository(
            orderDataSource = get()
        )
    }

    single<SubscriptionRepository> {
        SubscriptionRepositoryImpl(
            subscriptionDataSource = get()
        )
    }

    // Use cases
    factory {
        WorkManager.getInstance(androidApplication())
    }

    single {
        PublishDataChangeUseCase(
            workManager = get(),
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