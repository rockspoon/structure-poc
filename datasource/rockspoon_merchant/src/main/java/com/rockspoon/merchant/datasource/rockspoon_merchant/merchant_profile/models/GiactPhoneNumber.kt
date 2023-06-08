package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param areaCode
 * @param classification
 * @param exchange
 * @param numberType
 * @param phoneNumber
 * @param suffix
 */
@Serializable
data class GiactPhoneNumber(
    @SerialName("AreaCode")
    val areaCode: String? = null,
    @SerialName("Classification")
    val classification: String? = null,
    @SerialName("Exchange")
    val exchange: String? = null,
    @SerialName("NumberType")
    val numberType: String? = null,
    @SerialName("PhoneNumber")
    val phoneNumber: String? = null,
    @SerialName("Suffix")
    val suffix: String? = null
)

