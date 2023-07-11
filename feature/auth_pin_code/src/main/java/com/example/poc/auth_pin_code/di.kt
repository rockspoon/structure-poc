package com.example.poc.auth_pin_code

import com.example.poc.auth_pin_code.domain.SignInWithPinCodeUseCase
import com.example.poc.auth_pin_code.ui.main.AuthPinCodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

private val featurePinCodeAuthModule = module {

    viewModelOf(::AuthPinCodeViewModel)

    factoryOf(::SignInWithPinCodeUseCase)
}

private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featurePinCodeAuthModule)
}

fun loadModules() {
    lazyLoadModules.value
}