package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * Salary employment salary
 *
 * @param amount
 * @param currency
 */
@Serializable
data class Salary(
    val amount: Long? = null,
    val currency: String? = null
)

