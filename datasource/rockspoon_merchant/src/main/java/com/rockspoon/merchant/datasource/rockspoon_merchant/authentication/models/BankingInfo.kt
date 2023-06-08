package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param accountNumber
 * @param routingNumber
 */
@Serializable
data class BankingInfo(
    val accountNumber: String? = null,
    val routingNumber: String? = null
)

