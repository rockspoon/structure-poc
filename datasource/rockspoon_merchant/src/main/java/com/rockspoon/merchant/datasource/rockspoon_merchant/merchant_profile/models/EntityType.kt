package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Possible values are: \"individual\", \"cCorp\", \"sCorp\",
 * \"partnership\", \"trustEstate\", \"llc\", \"other\" . Values:
 * individual,cCorp,sCorp,partnership,trustEstate,llc,other
 */
@Serializable
enum class EntityType(val value: String) {

    @SerialName("individual")
    INDIVIDUAL("individual"),

    @SerialName("cCorp")
    CCORP("cCorp"),

    @SerialName("sCorp")
    SCORP("sCorp"),

    @SerialName("partnership")
    PARTNERSHIP("partnership"),

    @SerialName("trustEstate")
    TRUSTESTATE("trustEstate"),

    @SerialName("llc")
    LLC("llc"),

    @SerialName("other")
    OTHER("other");

}

