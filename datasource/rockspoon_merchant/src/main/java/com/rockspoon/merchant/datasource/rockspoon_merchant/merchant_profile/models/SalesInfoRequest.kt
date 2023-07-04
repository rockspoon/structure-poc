package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param cardPresentTransactions Percentage of card present transactions.
 * @param internetTransactions Percentage of internet transactions.
 * @param mailPhoneTransactions Percentage of mail orders and phone
 *     transactions.
 */
@Serializable
data class SalesInfoRequest(
    /** Percentage of card present transactions. */
    val cardPresentTransactions: Long,
    /** Percentage of internet transactions. */
    val internetTransactions: Long,
    /** Percentage of mail orders and phone transactions. */
    val mailPhoneTransactions: Long
)

