package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param AddressLine1
 * @param AddressLine2
 * @param City
 * @param DateReported
 * @param ParsedAddressLine1
 * @param State
 * @param Status
 * @param ZipCode
 */
@Serializable
data class GiactAddressRecord(
    @SerialName("AddressLine1")
    val addressLine1: String? = null,
    @SerialName("AddressLine2")
    val addressLine2: String? = null,
    @SerialName("City")
    val city: String? = null,
    @SerialName("DateReported")
    val dateReported: String? = null,
    @SerialName("ParsedAddressLine1")
    val parsedAddressLine1: GiactParsedAddressLine1? = null,
    @SerialName("State")
    val state: String? = null,
    @SerialName("Status")
    val status: String? = null,
    @SerialName("ZipCode")
    val zipCode: String? = null
)

