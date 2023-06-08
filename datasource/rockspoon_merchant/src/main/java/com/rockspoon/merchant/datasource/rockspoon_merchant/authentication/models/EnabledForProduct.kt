package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/** @param enabled */
@Serializable
data class EnabledForProduct(
    val enabled: Boolean? = null
)

