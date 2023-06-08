package com.rockspoon.merchant.datasource.rockspoon_merchant.order_prospect.model

import kotlinx.serialization.Serializable

@Serializable
data class ProspectDto(
	val id: String,
	val emails: Set<String>,
	val phones: Set<String>,
	val cardHolderName: String? = null,
	val redactedCardNumber: String? = null
)