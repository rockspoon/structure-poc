package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.Resolutions
import kotlinx.serialization.Serializable

@Serializable
data class ItemPhotoDto(
	val contentType: String?,
	val id: String?,
	val resolutions: Resolutions?
)