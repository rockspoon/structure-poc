package com.example.poc.core.domain

import com.example.poc.core.domain.preference.ObserveIsNotificationEnabledUseCase
import com.example.poc.core.domain.preference.ObserveThemeUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


val coreDomainModule = module {

    single {
        ObserveIsNotificationEnabledUseCase(
            coroutineDispatcher = Dispatchers.IO,
            preferenceDataSource = get()
        )
    }

    single {
        ObserveThemeUseCase(
            coroutineDispatcher = Dispatchers.IO,
            preferenceDataSource = get()
        )
    }
}