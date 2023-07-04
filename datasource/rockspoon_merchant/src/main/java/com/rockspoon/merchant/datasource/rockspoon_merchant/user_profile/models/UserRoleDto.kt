package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import kotlinx.serialization.Serializable

@Serializable
data class UserRoleDto(
	val id: String,
	val packages: List<String>?,
	val name: String?,
	val current: Boolean
)