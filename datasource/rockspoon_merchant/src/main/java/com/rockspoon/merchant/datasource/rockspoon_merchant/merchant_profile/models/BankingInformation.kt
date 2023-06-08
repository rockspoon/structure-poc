package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param accountName Account name.
 * @param accountNumber Account number.
 * @param accountType Account type.
 * @param bankName Bank name.
 * @param routingNumber Routing number.
 * @param beneficiaryName Beneficiary Name.
 */
@Serializable
data class BankingInformation(
    /** Account name. */
    val accountName: String? = null,
    /** Account number. */
    val accountNumber: String? = null,
    /** Account type. */
    val accountType: String? = null,
    /** Bank name. */
    val bankName: String? = null,
    /** Routing number. */
    val routingNumber: String? = null,
    /** Beneficiary Name. */
    val beneficiaryName: String? = null
)

