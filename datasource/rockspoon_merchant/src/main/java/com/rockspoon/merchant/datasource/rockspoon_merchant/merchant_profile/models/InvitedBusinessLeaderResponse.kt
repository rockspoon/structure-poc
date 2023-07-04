package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param inviteName
 * @param email
 * @param phoneNumber
 * @param active
 * @param createdAt
 * @param lastInviteSent
 */
@Serializable
data class InvitedBusinessLeaderResponse(
    val inviteName: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val active: Boolean? = null,
    val createdAt: Instant? = null,
    val lastInviteSent: Instant? = null
)

