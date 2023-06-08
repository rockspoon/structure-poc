package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param PostDirectional
 * @param PreDirectional
 * @param StreetName
 * @param StreetNumber
 * @param StreetSuffix
 * @param UnitIdentifier
 * @param UnitType
 */
@Serializable
data class GiactParsedAddressLine1(
    @SerialName("PostDirectional")
    val postDirectional: String? = null,
    @SerialName("PreDirectional")
    val preDirectional: String? = null,
    @SerialName("StreetName")
    val streetName: String? = null,
    @SerialName("StreetNumber")
    val streetNumber: String? = null,
    @SerialName("StreetSuffix")
    val streetSuffix: String? = null,
    @SerialName("UnitIdentifier")
    val unitIdentifier: String? = null,
    @SerialName("UnitType")
    val unitType: String? = null
)

