package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * stock device validation/creation response
 *
 * @param serialNumber Serial Number
 * @param externalId MDM ID
 * @param alreadyAdded AlreadyAdded flag
 */
@Serializable
data class StockResponse(
    /** Serial Number */
    val serialNumber: String? = null,
    /** MDM ID */
    val externalId: String? = null,
    /** AlreadyAdded flag */
    val alreadyAdded: Boolean? = null
)

