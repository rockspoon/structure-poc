package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * SendReferralInvitation response
 *
 * @param inviteLink
 */
@Serializable
data class ReferralInvitationResponse(
    val inviteLink: String? = null
)

