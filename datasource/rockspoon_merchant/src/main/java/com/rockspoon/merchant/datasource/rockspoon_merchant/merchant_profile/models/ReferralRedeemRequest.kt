package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * ReferralRedeemRequest request object
 *
 * @param amount redeem amount in cents
 * @param type
 * @param venueId venue that will receive bonus (is required when redeeming
 *     feeBonus, otherwise ignored)
 * @param bankAccountId id of user bank account that will receive cash
 *     bonus (is required when redeeming cash, otherwise ignored)
 */
@Serializable
data class ReferralRedeemRequest(
    /** redeem amount in cents */
    val amount: Long? = null,
    val type: ReferralRedeemType? = null,
    /**
     * venue that will receive bonus (is required when redeeming feeBonus,
     * otherwise ignored)
     */
    val venueId: String? = null,
    /**
     * id of user bank account that will receive cash bonus (is required when
     * redeeming cash, otherwise ignored)
     */
    val bankAccountId: String? = null
)

