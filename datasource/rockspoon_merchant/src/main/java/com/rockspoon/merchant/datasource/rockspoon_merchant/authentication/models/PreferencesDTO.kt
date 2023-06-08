package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param favoriteVenues
 * @param tipAmount
 * @param tipPercentage
 */
@Serializable
data class PreferencesDTO(
    val favoriteVenues: List<String>? = null,
    val tipAmount: Long? = null,
    val tipPercentage: Double? = null
)

