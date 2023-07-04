package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Values: website,facebook,twitter */
@Serializable
enum class WebsiteType(val value: String) {

    @SerialName("website")
    WEBSITE("website"),

    @SerialName("facebook")
    FACEBOOK("facebook"),

    @SerialName("twitter")
    TWITTER("twitter");

}

