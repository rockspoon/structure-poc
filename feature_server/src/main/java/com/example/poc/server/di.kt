package com.example.poc.server

import com.example.poc.server.service.OrderEndpoint
import com.example.poc.server.service.SubscriptionEndpoint
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

val featureServerModule = module {

    // TODO all the repositories and etc.

    single {
        OrderEndpoint()
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