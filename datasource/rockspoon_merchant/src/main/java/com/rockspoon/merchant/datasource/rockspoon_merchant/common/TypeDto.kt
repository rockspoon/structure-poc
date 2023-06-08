package com.rockspoon.merchant.datasource.rockspoon_merchant.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TypeDto(val value: String) {
	@SerialName("mobile")
	MOBILE("mobile"),

	@SerialName("")
	NONE("")
}