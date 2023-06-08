package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ImageDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PhoneDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfileSummaryDto(
	val id: String,
	val firstName: String,
	val lastName: String,
	val phone: PhoneDto?,
	val email: String?,
	@SerialName("employeePicture")
	val picture: ImageDto?,
	val role: UserRoleDto?,
	val roles: List<UserRoleDto>?
)