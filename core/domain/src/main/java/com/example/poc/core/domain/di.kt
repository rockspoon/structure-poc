package com.example.poc.core.domain

import com.example.poc.core.domain.preference.ObserveIsNotificationEnabledUseCase
import com.example.poc.core.domain.preference.ObserveThemeUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


fun coreDomainModule() = module {

    single {
        ObserveIsNotificationEnabledUseCase(
            coroutineDispatcher = get(),
            preferencesDataSource = get()
        )
    }

    single {
        ObserveThemeUseCase(
            coroutineDispatcher = get(),
            preferencesDataSource = get()
        )
    }
}