package com.example.poc.core.ui

import com.example.poc.core.ui.event.EventViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

fun coreUiModule() = module {

    viewModelOf(::EventViewModel)

}