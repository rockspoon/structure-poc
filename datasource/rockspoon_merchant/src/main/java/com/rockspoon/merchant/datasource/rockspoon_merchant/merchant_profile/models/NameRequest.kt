package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param name */
@Serializable
data class NameRequest(
    val name: String? = null
)

