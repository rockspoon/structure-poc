package com.example.poc.core.common.di

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

enum class CoroutineQualifiers(override val value: QualifierValue) : Qualifier {

    /**
     * Qualifier for CoroutineDispatcher for IO tasks
     */
    IO_DISPATCHER("IO_DISPATCHER"),

    /**
     * Qualifier for CoroutineDispatcher for computation tasks.
     */
    DEFAULT_DISPATCHER("DEFAULT_DISPATCHER"),

    /**
     * Qualifier for a CoroutineScope that follows the application lifecycle.
     */
    APPLICATION_SCOPE("APPLICATION_SCOPE")
}