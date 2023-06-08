package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ImageDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PhoneDto
import kotlinx.serialization.Serializable

@Serializable
data class UserProfileDto(
	val id: String,
	val firstName: String?,
	val lastName: String?,
	val employeePicture: ImageDto?,
	val picture: ImageDto? = null,
	val customerPicture: ImageDto?,
	val phone: PhoneDto?,
	val phones: List<PhoneDto>?,
	val email: String?,
	val pendingNewEmail: String?,
	val typefaceSettings: TypefaceSettingsDto?,
	val currentRole: UserRoleDto? = null,
	val roles: List<UserRoleDto>?,
	val deviceSettings: UserDeviceSettingsDto
)

