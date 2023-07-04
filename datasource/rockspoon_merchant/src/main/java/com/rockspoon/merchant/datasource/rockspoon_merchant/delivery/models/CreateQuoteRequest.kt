package com.rockspoon.merchant.datasource.rockspoon_merchant.delivery.models

data class CreateQuoteRequest(
	val asap: Boolean? = null,
	val scheduledFor: String? = null,
	val dropoffAddress: DropoffAddressDto,
)