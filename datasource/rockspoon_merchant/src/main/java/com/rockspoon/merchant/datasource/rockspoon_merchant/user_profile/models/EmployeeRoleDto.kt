package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class EmployeeRoleDto(
	val id: String,
	val description: String?,
	val name: String?,
	val startDate: Instant,
	val endDate: Instant?,
	val profiles: List<UserFullInfoDto>
)