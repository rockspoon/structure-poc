package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AppearanceDto {
	@SerialName("light")
	LIGHT,

	@SerialName("dark")
	DARK
}