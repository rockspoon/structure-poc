package com.example.settings

import com.example.settings.ui.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

val featureSettingsModules = module {

    viewModelOf(::SettingsViewModel)
}

// Use lazy to only call it once
private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featureSettingsModules)
}

fun loadModules() {
    lazyLoadModules.value
}