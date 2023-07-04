package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Period represents period model
 *
 * @param from
 * @param to
 * @param shiftName
 */
@Serializable
data class Period(
    val from: String? = null,
    val to: String? = null,
    val shiftName: String? = null
)

