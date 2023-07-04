package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * VerificationStatus enum for business entity kyc and credit verification
 * status response Values: error,pending,fail,pass
 */
@Serializable
enum class VerificationStatus(val value: String) {

    @SerialName("error")
    ERROR("error"),

    @SerialName("pending")
    PENDING("pending"),

    @SerialName("fail")
    FAIL("fail"),

    @SerialName("pass")
    PASS("pass");

}

