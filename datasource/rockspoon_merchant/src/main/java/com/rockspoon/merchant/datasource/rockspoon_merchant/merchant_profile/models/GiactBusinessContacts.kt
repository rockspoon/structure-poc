package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @param giactBusinessContact */
@Serializable
data class GiactBusinessContacts(
    @SerialName("GiactBusinessContact")
    val giactBusinessContact: List<GiactBusinessContact>? = null
)

