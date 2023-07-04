package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/** @param tipPercentage */
@Serializable
data class PreferencesResponse(
    val tipPercentage: Double? = null
)

