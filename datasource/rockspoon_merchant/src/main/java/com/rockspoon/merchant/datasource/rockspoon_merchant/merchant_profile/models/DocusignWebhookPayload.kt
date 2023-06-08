package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Holds data sent by DocuSign webhook
 *
 * @param createdDateTime envelope creation time
 * @param envelopeId DocuSign envelope ID
 * @param lastModifiedDateTime envelope last modification time
 * @param status DocuSign envelope status
 * @param statusChangedDateTime envelope status change time
 */
@Serializable
data class DocusignWebhookPayload(
    /** DocuSign envelope ID */
    val envelopeId: String,
    /** DocuSign envelope status */
    val status: Status,
    /** envelope creation time */
    val createdDateTime: Instant? = null,
    /** envelope last modification time */
    val lastModifiedDateTime: Instant? = null,
    /** envelope status change time */
    val statusChangedDateTime: Instant? = null
) {

    /**
     * DocuSign envelope status Values:
     * completed,created,declined,delivered,sent,signed,voided
     */
    @Serializable
    enum class Status(val value: String) {

        @SerialName("completed")
        COMPLETED("completed"),

        @SerialName("created")
        CREATED("created"),

        @SerialName("declined")
        DECLINED("declined"),

        @SerialName("delivered")
        DELIVERED("delivered"),

        @SerialName("sent")
        SENT("sent"),

        @SerialName("signed")
        SIGNED("signed"),

        @SerialName("voided")
        VOIDED("voided");

    }

}

