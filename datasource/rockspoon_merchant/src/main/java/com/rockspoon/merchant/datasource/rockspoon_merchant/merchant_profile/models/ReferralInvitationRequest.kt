package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * SendReferralInvitation request
 *
 * @param inviteType
 * @param message
 */
@Serializable
data class ReferralInvitationRequest(
    val inviteType: InviteType,
    val message: String? = null
) {

    /** Values: email,link */
    @Serializable
    enum class InviteType(val value: String) {

        @SerialName("email")
        EMAIL("email"),

        @SerialName("link")
        LINK("link");

    }

}

