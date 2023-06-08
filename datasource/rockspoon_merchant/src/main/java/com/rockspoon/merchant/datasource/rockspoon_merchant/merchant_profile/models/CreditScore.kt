package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param ceilingValue
 * @param classification
 * @param floorValue
 * @param value
 */
@Serializable
data class CreditScore(
    val ceilingValue: Long? = null,
    val classification: String? = null,
    val floorValue: Long? = null,
    val value: Long? = null
)

