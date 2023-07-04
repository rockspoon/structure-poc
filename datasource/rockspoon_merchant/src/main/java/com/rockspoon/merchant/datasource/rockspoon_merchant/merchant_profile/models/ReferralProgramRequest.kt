package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * request information for creationg a referral program
 *
 * @param name
 * @param canRedeem Defines whether redemption is manual or not
 * @param limitInvites Defines whether there is an invitation limit or not
 */
@Serializable
data class ReferralProgramRequest(
    val name: String,
    /** Defines whether redemption is manual or not */
    val canRedeem: Boolean? = null,
    /** Defines whether there is an invitation limit or not */
    val limitInvites: Boolean? = null
)

