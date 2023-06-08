package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param profileId profile id to invite to demo venues */
@Serializable
data class InviteRequest(
    /** profile id to invite to demo venues */
    val profileId: String? = null
)

