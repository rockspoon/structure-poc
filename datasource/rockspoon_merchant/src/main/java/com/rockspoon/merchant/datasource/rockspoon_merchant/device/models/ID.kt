package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * ID data transfer object
 *
 * @param id ID
 */
@Serializable
data class ID(
    /** ID */
    val id: String? = null
)

