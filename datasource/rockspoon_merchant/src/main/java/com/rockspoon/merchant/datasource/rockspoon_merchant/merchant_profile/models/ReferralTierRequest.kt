package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ReferralTierRequest referral tier request dto. Only one information is
 * required (prizeInfo, basisPointsInfo or marginInfo), depending on the
 * type
 *
 * @param type
 * @param prizeInfo Required if referral tier type is prize
 * @param basisPointsInfo Required if referral tier type is basisPoints
 * @param marginInfo Required if referral tier type is margin
 * @param referralProgramId
 * @param startDate
 * @param endDate
 */
@Serializable
data class ReferralTierRequest(
    val type: Type? = null,
    /** Required if referral tier type is prize */
    val prizeInfo: PrizeInfoRequest? = null,
    /** Required if referral tier type is basisPoints */
    val basisPointsInfo: BasisPointsInfo? = null,
    /** Required if referral tier type is margin */
    val marginInfo: String? = null,
    val referralProgramId: String? = null,
    val startDate: Instant? = null,
    val endDate: Instant? = null
) {

    /** Values: prize,basisPoints,margin */
    @Serializable
    enum class Type(val value: String) {

        @SerialName("prize")
        PRIZE("prize"),

        @SerialName("basisPoints")
        BASISPOINTS("basisPoints"),

        @SerialName("margin")
        MARGIN("margin");

    }

}

