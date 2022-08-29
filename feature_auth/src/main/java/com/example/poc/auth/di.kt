package com.example.poc.auth

import com.example.poc.Qualifiers
import com.example.poc.auth.domain.SignUpWithPasswordUseCase
import com.example.poc.auth.ui.main.AuthViewModel
import com.example.poc.auth.ui.main.EmailInputDelegate
import com.example.poc.auth.ui.main.EmailInputDelegateImpl
import com.example.poc.auth.ui.main.ValidateEmailUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

private val featureAuthModule = module {

    single {
        SignUpWithPasswordUseCase(
            coroutineDispatcher = get(Qualifiers.dispatcherIO),
            userRepository = get()
        )
    }

    single {
        ValidateEmailUseCase()
    }

    factory<EmailInputDelegate> {
        EmailInputDelegateImpl(
            validateEmailUseCase = get()
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