package com.rockspoon.merchant.datasource.rockspoon_merchant.common

import kotlinx.serialization.Serializable

@Serializable
data class PhoneDto(
	val countryCode: String? = null,
	val isDefault: Boolean? = null,
	val isValidated: Boolean? = null,
	val phoneNumber: String? = null,
	val status: String? = null,
	val type: TypeDto? = null
)