package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Referral's status history
 *
 * @param date
 * @param status
 */
@Serializable
data class StatusHistory(
    val date: Instant? = null,
    val status: Status? = null
) {

    /**
     * Values:
     * contactAdded,invitationSent,userAlreadyInvited,invitationOpened,onboardingStarted,invitationToSignSentToRepresentative,onboardingDone,firstPayment,processingVolumeReached
     */
    @Serializable
    enum class Status(val value: String) {

        @SerialName("contactAdded")
        CONTACTADDED("contactAdded"),

        @SerialName("invitationSent")
        INVITATIONSENT("invitationSent"),

        @SerialName("userAlreadyInvited")
        USERALREADYINVITED("userAlreadyInvited"),

        @SerialName("invitationOpened")
        INVITATIONOPENED("invitationOpened"),

        @SerialName("onboardingStarted")
        ONBOARDINGSTARTED("onboardingStarted"),

        @SerialName("invitationToSignSentToRepresentative")
        INVITATIONTOSIGNSENTTOREPRESENTATIVE("invitationToSignSentToRepresentative"),

        @SerialName("onboardingDone")
        ONBOARDINGDONE("onboardingDone"),

        @SerialName("firstPayment")
        FIRSTPAYMENT("firstPayment"),

        @SerialName("processingVolumeReached")
        PROCESSINGVOLUMEREACHED("processingVolumeReached");

    }

}

