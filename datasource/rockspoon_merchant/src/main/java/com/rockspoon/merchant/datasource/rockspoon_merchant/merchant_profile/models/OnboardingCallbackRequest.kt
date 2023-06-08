package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param errorMessage
 * @param merchantID Merchant ID.
 * @param result Callback Result.
 */
@Serializable
data class OnboardingCallbackRequest(
    /** Merchant ID. */
    val merchantID: String,
    /** Callback Result. */
    val result: Result,
    val errorMessage: String? = null
) {

    /** Callback Result. Values: success,retry_error,status_error */
    @Serializable
    enum class Result(val value: String) {

        @SerialName("success")
        SUCCESS("success"),

        @SerialName("retry-error")
        RETRY_ERROR("retry-error"),

        @SerialName("status-error")
        STATUS_ERROR("status-error");

    }

}

