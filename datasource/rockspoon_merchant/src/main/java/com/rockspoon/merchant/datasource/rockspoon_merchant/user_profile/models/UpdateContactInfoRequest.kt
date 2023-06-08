package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PhoneDto
import kotlinx.serialization.Serializable

@Serializable
data class UpdateContactInfoRequest(
	val email: String,
	val phone: PhoneDto?
)