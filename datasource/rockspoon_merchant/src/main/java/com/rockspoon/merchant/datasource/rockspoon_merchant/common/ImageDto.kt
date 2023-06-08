package com.rockspoon.merchant.datasource.rockspoon_merchant.common

import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.ImageResolutionDto
import kotlinx.serialization.Serializable

@Serializable
data class ImageDto(
	val hiResolution: ImageResolutionDto?,
	val loResolution: ImageResolutionDto?,
	val noResolution: ImageResolutionDto?
)