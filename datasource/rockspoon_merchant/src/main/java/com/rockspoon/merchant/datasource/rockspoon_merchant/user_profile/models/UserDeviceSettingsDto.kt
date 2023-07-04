package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import kotlinx.serialization.Serializable

@Serializable
data class UserDeviceSettingsDto(
	val fontSize: Int,
	val course: Boolean,
	val defaultZoom: Boolean,
	val brightness: Int,
	val appearance: AppearanceDto?,
	val changeAppearanceAutomatically: Boolean?
)