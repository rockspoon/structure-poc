package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param FirstName
 * @param LastName
 * @param MiddleName
 * @param Title
 */
@Serializable
data class GiactBusinessContact(
    @SerialName("FirstName")
    val firstName: String? = null,
    @SerialName("LastName")
    val lastName: String? = null,
    @SerialName("MiddleName")
    val middleName: String? = null,
    @SerialName("Title")
    val title: String? = null
)

