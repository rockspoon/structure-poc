package com.example.poc.client

import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.poc.client.data.MessageDataSource
import com.example.poc.client.data.MessageDataSourceImpl
import com.example.poc.client.data.MessageRepository
import com.example.poc.client.data.MessageRepositoryImpl
import com.example.poc.client.domain.NotifyDataChangedUseCase
import com.example.poc.client.service.SyncEndpoint
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

val featureClientModule = module {

    // BroadcastManager
    single {
        LocalBroadcastManager.getInstance(androidApplication())
    }

    // Data sources
    single<MessageDataSource> {
        MessageDataSourceImpl(
            localBroadcastManager = get()
        )
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
        SyncEndpoint(
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