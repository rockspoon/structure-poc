package com.example.poc.client

import com.example.poc.client.data.MessageDataSource
import com.example.poc.client.data.MessageDataSourceImpl
import com.example.poc.client.data.MessageRepository
import com.example.poc.client.data.MessageRepositoryImpl
import com.example.poc.client.domain.NotifyDataChangedUseCase
import com.example.poc.client.service.MessageEndpoint
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

val featureClientModule = module {

    // Data sources
    single<MessageDataSource> {
        MessageDataSourceImpl()
    }

    // Repositories
    single<MessageRepository> {
        MessageRepositoryImpl(
            messageDataSource = get()
        )
    }

    // Use cases
    single {
        NotifyDataChangedUseCase(
            messageRepository = get()
        )
    }

    // Endpoints
    single {
        MessageEndpoint(
            notifyDataChangedUseCase = get()
        )
    }
}

private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featureClientModule)
}

fun loadModules() {
    lazyLoadModules.value
}