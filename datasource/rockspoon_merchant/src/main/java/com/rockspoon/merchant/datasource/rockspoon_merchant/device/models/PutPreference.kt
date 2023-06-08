package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * put preference data transfer object (little bit different from get)
 *
 * @param display
 * @param font
 */
@Serializable
data class PutPreference(
    val display: Display? = null,
    val font: Font? = null
)

