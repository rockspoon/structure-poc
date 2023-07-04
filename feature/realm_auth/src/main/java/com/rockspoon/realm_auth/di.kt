package com.rockspoon.realm_auth

import com.rockspoon.realm_auth.domain.LoginWithEmailUseCase
import com.rockspoon.realm_auth.ui.RealmAuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun featureRealmAuthModule() = module {
    viewModelOf(::RealmAuthViewModel)

    factoryOf(::LoginWithEmailUseCase)
}