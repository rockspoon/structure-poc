package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param status */
@Serializable
data class ValidateResponse(
    val status: Boolean? = null
)

