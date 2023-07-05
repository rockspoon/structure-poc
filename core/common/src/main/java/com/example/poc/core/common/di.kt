package com.example.poc.core.common

import com.example.poc.core.common.di.CoroutineQualifiers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
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

    single(CoroutineQualifiers.APPLICATION_SCOPE) {
        CoroutineScope(
            SupervisorJob() + get<CoroutineDispatcher>(CoroutineQualifiers.DEFAULT_DISPATCHER)
        )
    }

    single(CoroutineQualifiers.DEFAULT_DISPATCHER) {
        Dispatchers.Default
    }
}