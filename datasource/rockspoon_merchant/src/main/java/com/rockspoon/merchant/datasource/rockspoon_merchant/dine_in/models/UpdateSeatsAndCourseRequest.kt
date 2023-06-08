package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.Serializable

@Serializable
data class UpdateSeatsAndCourseRequest(
	val orderItemIds: List<String>,
	val orderBundleItemIds: List<String>,
	val orderCustomerIds: List<String>?,
	val course: Int?
)