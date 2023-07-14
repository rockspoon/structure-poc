package com.example.poc.settings

import com.example.poc.settings.domain.UpdateIsNotificationEnabledUseCase
import com.example.poc.settings.domain.UpdateThemeUseCase
import com.example.poc.settings.ui.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun featureSettingsModule() = module {

    singleOf(::UpdateIsNotificationEnabledUseCase)

    singleOf(::UpdateThemeUseCase)

    viewModelOf(::SettingsViewModel)

}

// Use lazy to only call it once
private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featureSettingsModule())
}

fun loadModules() {
    lazyLoadModules.value
}