package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * contains the rules for a group of ReferralTiers and ReferralBalances
 *
 * @param id
 * @param name
 * @param canRedeem Defines whether redemption is manual or not
 * @param limitInvites Defines whether there is an invitation limit or not
 * @param createdAt
 */
@Serializable
data class ReferralProgramResponse(
    val id: String? = null,
    val name: String? = null,
    /** Defines whether redemption is manual or not */
    val canRedeem: Boolean? = null,
    /** Defines whether there is an invitation limit or not */
    val limitInvites: Boolean? = null,
    val createdAt: Instant? = null
)

