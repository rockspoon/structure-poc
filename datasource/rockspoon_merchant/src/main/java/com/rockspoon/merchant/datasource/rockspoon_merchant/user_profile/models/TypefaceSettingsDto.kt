package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import kotlinx.serialization.Serializable

@Serializable
data class TypefaceSettingsDto(
	val textSizeMobilePos: String? = null,
	val textSizeFixedPos: String? = null
)