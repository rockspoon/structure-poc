package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param orderId */
@Serializable
data class DeviceOrderIdRequest(
    val orderId: String? = null
)

