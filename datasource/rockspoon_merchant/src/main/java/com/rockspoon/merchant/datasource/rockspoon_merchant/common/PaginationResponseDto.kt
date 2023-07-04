package com.rockspoon.merchant.datasource.rockspoon_merchant.common

import kotlinx.serialization.Serializable

@Serializable
class PaginationResponseDto<T : Any>(
	val total: Int,
	val nextId: String?,
	val previousId: String?,
	val result: List<T>?
)