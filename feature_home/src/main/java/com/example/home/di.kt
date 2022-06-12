package com.example.home

import com.example.core.domain.user.ObserveUserUseCase
import com.example.home.ui.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

val featureHomeModules = module {

    single {
        ObserveUserUseCase(
            coroutineDispatcher = Dispatchers.IO,
            userRepository = get()
        )
    }

    viewModelOf(::HomeViewModel)
}

private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featureHomeModules)
}

fun loadModules() {
    lazyLoadModules.value
}