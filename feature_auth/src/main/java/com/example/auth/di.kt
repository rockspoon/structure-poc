package com.example.auth

import com.example.auth.domain.SignUpWithPasswordUseCase
import com.example.auth.ui.auth.AuthViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

private val featureAuthModule = module {

    single {
        SignUpWithPasswordUseCase(
                coroutineDispatcher = Dispatchers.IO,
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