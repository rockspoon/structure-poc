package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param AccountAddedDate
 * @param AccountClosedDate
 * @param AccountLastUpdatedDate
 * @param AccountResponseCode
 * @param BankAccountType
 * @param BankName
 * @param ConsumerAlertMessages
 * @param CreatedDate
 * @param CustomerResponseCode
 * @param ErrorMessage
 * @param FundsConfirmationResult
 * @param ItemReferenceId
 * @param MatchedBusinessData
 * @param MatchedPersonData
 * @param OfacListPotentialMatches
 * @param VerificationResponse
 */
@Serializable
data class GiactResponse(
    @SerialName("AccountAddedDate")
    val accountAddedDate: String? = null,
    @SerialName("AccountClosedDate")
    val accountClosedDate: String? = null,
    @SerialName("AccountLastUpdatedDate")
    val accountLastUpdatedDate: String? = null,
    @SerialName("AccountResponseCode")
    val accountResponseCode: String? = null,
    @SerialName("BankAccountType")
    val bankAccountType: String? = null,
    @SerialName("BankName")
    val bankName: String? = null,
    @SerialName("ConsumerAlertMessages")
    val consumerAlertMessages: GiactConsumerAlertMessage? = null,
    @SerialName("CreatedDate")
    val createdDate: String? = null,
    @SerialName("CustomerResponseCode")
    val customerResponseCode: String? = null,
    @SerialName("ErrorMessage")
    val errorMessage: String? = null,
    @SerialName("FundsConfirmationResult")
    val fundsConfirmationResult: String? = null,
    @SerialName("ItemReferenceId")
    val itemReferenceId: String? = null,
    @SerialName("MatchedBusinessData")
    val matchedBusinessData: GiactMatchedBusinessData? = null,
    @SerialName("MatchedPersonData")
    val matchedPersonData: GiactMatchedPersonData? = null,
    @SerialName("OfacListPotentialMatches")
    val ofacListPotentialMatches: GiactOfacPotentialMatches? = null,
    @SerialName("VerificationResponse")
    val verificationResponse: String? = null
)

