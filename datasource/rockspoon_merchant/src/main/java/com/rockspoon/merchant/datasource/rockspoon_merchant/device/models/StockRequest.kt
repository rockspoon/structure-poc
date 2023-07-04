package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * stock device validation/creation request
 *
 * @param serialNumber Serial Number
 */
@Serializable
data class StockRequest(
    /** Serial Number */
    val serialNumber: String? = null
)

