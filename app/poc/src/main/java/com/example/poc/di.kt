package com.example.poc

import com.example.poc.ui.*
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

fun appPocModule() = module {

    factory<AuthEventDelegate> {
        AuthEventDelegateImpl()
    }

    factory<MainEventDelegate> {
        MainEventDelegateImpl()
    }

    factory<SettingsEventDelegate> {
        SettingsEventDelegateImpl()
    }

    viewModelOf(::MainViewModel)

}