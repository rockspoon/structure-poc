package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param evaluation
 * @param modelIndicator
 * @param score
 * @param scoreFactors
 */
@Serializable
data class RiskModel(
    val evaluation: Evaluation? = null,
    val modelIndicator: String? = null,
    val score: String? = null,
    val scoreFactors: List<ScoreFactors>? = null
) {

    /** Values: p,n */
    @Serializable
    enum class Evaluation(val value: String) {

        @SerialName("P")
        P("P"),

        @SerialName("N")
        N("N");

    }

}

