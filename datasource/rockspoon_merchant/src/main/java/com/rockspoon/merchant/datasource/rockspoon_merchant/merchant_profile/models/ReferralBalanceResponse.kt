package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param id
 * @param profileId
 * @param referralProgramId
 * @param balanceCash
 * @param balanceFeeBonus
 * @param availableInvites
 * @param lastUpdate
 * @param createdAt
 */
@Serializable
data class ReferralBalanceResponse(
    val id: String? = null,
    val profileId: String? = null,
    val referralProgramId: String? = null,
    val balanceCash: Long? = null,
    val balanceFeeBonus: Long? = null,
    val availableInvites: Int? = null,
    val lastUpdate: Instant? = null,
    val createdAt: Instant? = null
)

