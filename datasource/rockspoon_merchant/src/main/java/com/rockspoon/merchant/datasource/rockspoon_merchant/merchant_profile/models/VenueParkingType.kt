package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Possible values are: \"paid_self\", \"free_self\", \"paid_valet\",
 * \"free_valet\" Values: paidSelf,freeSelf,paidValet,freeValet
 */
@Serializable
enum class VenueParkingType(val value: String) {

    @SerialName("paid_self")
    PAIDSELF("paid_self"),

    @SerialName("free_self")
    FREESELF("free_self"),

    @SerialName("paid_valet")
    PAIDVALET("paid_valet"),

    @SerialName("free_valet")
    FREEVALET("free_valet");

}

