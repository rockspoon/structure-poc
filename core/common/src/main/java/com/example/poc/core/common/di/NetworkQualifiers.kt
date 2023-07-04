package com.example.poc.core.common.di

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

enum class NetworkQualifiers(override val value: QualifierValue) : Qualifier {

	REQUEST_READ_TIMEOUT_MILLISECONDS("REQUEST_READ_TIMEOUT_MILLISECONDS"),

	REQUEST_WRITE_TIMEOUT_MILLISECONDS("REQUEST_WRITE_TIMEOUT_MILLISECONDS"),

	REQUEST_CONNECTION_TIMEOUT_MILLISECONDS("REQUEST_CONNECTION_TIMEOUT_MILLISECONDS"),

	ROCKSPOON_MERCHANT_CLIENT_RETROFIT("ROCKSPOON_MERCHANT_CLIENT_RETROFIT"),

	ROCKSPOON_PAYMENT_CLIENT_RETROFIT("ROCKSPOON_PAYMENT_CLIENT_RETROFIT"),

}