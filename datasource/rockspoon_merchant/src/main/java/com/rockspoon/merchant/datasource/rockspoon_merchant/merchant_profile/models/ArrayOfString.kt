package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ArrayOfString is an array of string
 *
 * @param string
 */
@Serializable
data class ArrayOfString(
    @SerialName("String")
    val string: List<String>? = null
)

