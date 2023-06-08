package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param documentIssuer
 * @param documentType
 * @param expireDate
 * @param idNumber
 * @param issueDate
 * @param issuingState Document Issuing State (only for US docs) in ISO
 *     3166-2 format.
 */
@Serializable
data class OwnerDocumentDetails(
    val documentIssuer: String? = null,
    val documentType: DocumentType? = null,
    val expireDate: Instant? = null,
    val idNumber: String? = null,
    val issueDate: Instant? = null,
    /** Document Issuing State (only for US docs) in ISO 3166-2 format. */
    val issuingState: String? = null
) {

    /**
     * Values:
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

