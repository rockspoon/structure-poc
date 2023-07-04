package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** referralprize redeem type Values: cash,feeBonus */
@Serializable
enum class ReferralRedeemType(val value: String) {

    @SerialName("cash")
    CASH("cash"),

    @SerialName("feeBonus")
    FEEBONUS("feeBonus");

}

