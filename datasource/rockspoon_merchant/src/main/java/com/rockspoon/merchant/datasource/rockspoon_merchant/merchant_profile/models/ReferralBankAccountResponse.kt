package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param id
 * @param accountNumber
 * @param accountType
 * @param routingNumber
 * @param bankName
 * @param primary
 */
@Serializable
data class ReferralBankAccountResponse(
    val id: String? = null,
    val accountNumber: String? = null,
    val accountType: String? = null,
    val routingNumber: String? = null,
    val bankName: String? = null,
    val primary: Boolean? = null
)

