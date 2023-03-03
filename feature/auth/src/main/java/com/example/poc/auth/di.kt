package com.example.poc.auth

import com.example.poc.auth.domain.SignUpWithPasswordUseCase
import com.example.poc.auth.ui.main.AuthViewModel
import com.example.poc.core.common.di.CoroutineQualifiers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

private val featureAuthModule = module {

    single {
        SignUpWithPasswordUseCase(
            coroutineDispatcher = get(CoroutineQualifiers.IO_DISPATCHER),
            userRepository = get()
        )
    }

    viewModelOf(::AuthViewModel)
}

private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featureAuthModule)
}

fun loadModules() {
    lazyLoadModules.value
}