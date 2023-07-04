package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param FirstName
 * @param LastName
 * @param ListItemName
 * @param MiddleName
 */
@Serializable
data class GiactBusinessName(
    @SerialName("FirstName")
    val firstName: String? = null,
    @SerialName("LastName")
    val lastName: String? = null,
    @SerialName("ListItemName")
    val listItemName: String? = null,
    @SerialName("MiddleName")
    val middleName: String? = null
)

