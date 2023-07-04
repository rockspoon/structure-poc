package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param id
 * @param mcc
 * @param name
 * @param merchantId
 * @param servicePackage
 * @param status
 */
@Serializable
data class ListBusinessEntitiesResponse(
    val id: String? = null,
    val mcc: String? = null,
    val name: String? = null,
    val merchantId: String? = null,
    val servicePackage: String? = null,
    val status: Status? = null
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

