package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param id
 * @param name
 * @param createdAt
 * @param merchantId
 * @param planId
 * @param planName
 * @param status
 * @param city
 * @param state
 */
@Serializable
data class ListBusinessEntitiesForAdminResponse(
    val id: String? = null,
    val name: String? = null,
    val createdAt: Instant? = null,
    val merchantId: String? = null,
    val planId: String? = null,
    val planName: String? = null,
    val status: Status? = null,
    val city: String? = null,
    val state: String? = null
) {

    /**
     * Values:
     * notValidated,validationFailedKyc,validationFailedCredit,validationFailedKycCredit,valid
     */
    @Serializable
    enum class Status(val value: String) {

        @SerialName("not_validated")
        NOTVALIDATED("not_validated"),

        @SerialName("validation_failed_kyc")
        VALIDATIONFAILEDKYC("validation_failed_kyc"),

        @SerialName("validation_failed_credit")
        VALIDATIONFAILEDCREDIT("validation_failed_credit"),

        @SerialName("validation_failed_kyc_credit")
        VALIDATIONFAILEDKYCCREDIT("validation_failed_kyc_credit"),

        @SerialName("valid")
        VALID("valid");

    }

}

