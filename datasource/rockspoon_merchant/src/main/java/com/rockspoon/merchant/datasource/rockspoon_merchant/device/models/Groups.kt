package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Groups encapsulate device groups response
 *
 * @param groups
 */
@Serializable
data class Groups(
    val groups: List<String>? = null
)

