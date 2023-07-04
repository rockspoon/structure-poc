package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ImageDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PhoneDto
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class ConsumerProfileDto(
	val id: String,
	val phone: PhoneDto?,
	val email: String?,
	val username: String?,
	val birthDate: LocalDate?,
	val firstName: String?,
	val lastName: String?,
	val customerPicture: ImageDto?,
	val employeePicture: ImageDto?
)