package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A referral transaction
 *
 * @param id
 * @param profileId
 * @param balanceId
 * @param referralId
 * @param bankAccountId
 * @param transactionAmount transaction amount in cents
 * @param redeemType
 * @param transactionType
 * @param createdAt
 */
@Serializable
data class ReferralTransaction(
    val id: String? = null,
    val profileId: String? = null,
    val balanceId: String? = null,
    val referralId: String? = null,
    val bankAccountId: String? = null,
    /** transaction amount in cents */
    val transactionAmount: Long? = null,
    val redeemType: ReferralRedeemType? = null,
    val transactionType: TransactionType? = null,
    val createdAt: Instant? = null
) {

    /** Values: credit,debit */
    @Serializable
    enum class TransactionType(val value: String) {

        @SerialName("credit")
        CREDIT("credit"),

        @SerialName("debit")
        DEBIT("debit");

    }

}

