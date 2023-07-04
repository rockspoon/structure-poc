package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/** @param result */
@Serializable
data class BoolResponse(
    val result: Boolean? = null
)

