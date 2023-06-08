package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param documentIssuer Document Issuer.
 * @param documentType Document Type.
 * @param expireDate Document Expire Date.
 * @param idNumber Document ID Number.
 * @param issueDate Document Issue Date.
 * @param issuingState Document Issuing State (only for US docs) in ISO
 *     3166-2 format.
 */
@Serializable
data class DocumentDetailsRequest(
    /** Document Issuer. */
    val documentIssuer: String,
    /** Document Type. */
    val documentType: DocumentType,
    /** Document Expire Date. */
    val expireDate: String,
    /** Document ID Number. */
    val idNumber: String,
    /** Document Issue Date. */
    val issueDate: String,
    /** Document Issuing State (only for US docs) in ISO 3166-2 format. */
    val issuingState: String? = null
) {

    /**
     * Document Type. Values:
     * driversLicence,usaMilitaryId,usaStateId,passportUsa,passportForeign,usaResidentAlienId,studentId,tribalId,dlCanada,dlMexico,otherIdForeign
     */
    @Serializable
    enum class DocumentType(val value: String) {

        @SerialName("DriversLicence")
        DRIVERSLICENCE("DriversLicence"),

        @SerialName("UsaMilitaryId")
        USAMILITARYID("UsaMilitaryId"),

        @SerialName("UsaStateId")
        USASTATEID("UsaStateId"),

        @SerialName("PassportUsa")
        PASSPORTUSA("PassportUsa"),

        @SerialName("PassportForeign")
        PASSPORTFOREIGN("PassportForeign"),

        @SerialName("UsaResidentAlienId")
        USARESIDENTALIENID("UsaResidentAlienId"),

        @SerialName("StudentId")
        STUDENTID("StudentId"),

        @SerialName("TribalId")
        TRIBALID("TribalId"),

        @SerialName("DlCanada")
        DLCANADA("DlCanada"),

        @SerialName("DlMexico")
        DLMEXICO("DlMexico"),

        @SerialName("OtherIdForeign")
        OTHERIDFOREIGN("OtherIdForeign");

    }

}

