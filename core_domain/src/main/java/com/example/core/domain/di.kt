package com.example.core.domain

import com.example.core.domain.preference.ObserveIsNotificationEnabledUseCase
import com.example.core.domain.preference.ObserveThemeUseCase
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