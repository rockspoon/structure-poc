package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.Serializable

@Serializable
data class UpdateNeedAssistanceRequest(
	val needsAssistance: Boolean = false
)