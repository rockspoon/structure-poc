package com.example.poc.core.common

import com.example.poc.core.common.di.CoroutineQualifiers
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.dsl.module

fun coreCommonModule() = module {

    includes(coroutineModule())
}

private fun coroutineModule() = module {

    single {
        Dispatchers.IO
    }

    single(CoroutineQualifiers.IO_DISPATCHER) {
        Dispatchers.IO
    }
}