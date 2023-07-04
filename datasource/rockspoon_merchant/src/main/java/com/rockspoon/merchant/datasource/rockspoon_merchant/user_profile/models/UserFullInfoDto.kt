package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ImageDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PhoneDto
import kotlinx.serialization.Serializable

@Serializable
data class UserFullInfoDto(
	val id: String,
	val phone: PhoneDto?,
	val firstName: String?,
	val lastName: String?,
	val picture: ImageDto?,
	val status: String?
)