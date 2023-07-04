package com.example.poc.home

import com.example.poc.core.domain.user.ObserveUserUseCase
import com.example.poc.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

val featureHomeModules = module {

    single {
        ObserveUserUseCase(
            coroutineDispatcher = get(),
            userRepository = get()
        )
    }

    viewModelOf(::HomeViewModel)
}


// Maybe I can make a delegate for this and just call by LoadModulesDelegate
private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featureHomeModules)
}

fun loadModules() {
    lazyLoadModules.value
}