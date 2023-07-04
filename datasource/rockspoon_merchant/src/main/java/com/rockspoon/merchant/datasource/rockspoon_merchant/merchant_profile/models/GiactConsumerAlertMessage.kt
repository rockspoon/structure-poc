package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @param consumerAlertMessage */
@Serializable
data class GiactConsumerAlertMessage(
    @SerialName("ConsumerAlertMessage")
    val consumerAlertMessage: List<ConsumerAlertMessage>? = null
)

