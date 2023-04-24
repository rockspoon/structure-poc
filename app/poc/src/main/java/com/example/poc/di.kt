package com.example.poc

import com.example.poc.ui.main.AppPocEventDelegate
import com.example.poc.ui.main.AppPocEventDelegateImpl
import com.example.poc.ui.main.FeatureAuthEventDelegate
import com.example.poc.ui.main.FeatureAuthEventDelegateImpl
import com.example.poc.ui.main.FeatureSearchEventDelegate
import com.example.poc.ui.main.FeatureSearchEventDelegateImpl
import com.example.poc.ui.main.FeatureSettingsEventDelegate
import com.example.poc.ui.main.FeatureSettingsEventDelegateImpl
import com.example.poc.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun appPocModule() = module {

    factoryOf<AppPocEventDelegate>(::AppPocEventDelegateImpl)

    factoryOf<FeatureAuthEventDelegate>(::FeatureAuthEventDelegateImpl)

    factoryOf<FeatureSearchEventDelegate>(::FeatureSearchEventDelegateImpl)

    factoryOf<FeatureSettingsEventDelegate>(::FeatureSettingsEventDelegateImpl)

    viewModelOf(::MainViewModel)
}