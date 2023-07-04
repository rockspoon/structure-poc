package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import kotlinx.serialization.Serializable

@Serializable
data class ImageResolutionDto(
	val url: String?,
	val width: Int,
	val height: Int
)