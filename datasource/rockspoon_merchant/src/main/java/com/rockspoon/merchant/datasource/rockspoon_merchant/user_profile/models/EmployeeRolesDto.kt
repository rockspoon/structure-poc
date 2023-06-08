package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import kotlinx.serialization.Serializable

@Serializable
data class EmployeeRolesDto(
	val name: String,
	val roles: List<EmployeeRoleDto>
)