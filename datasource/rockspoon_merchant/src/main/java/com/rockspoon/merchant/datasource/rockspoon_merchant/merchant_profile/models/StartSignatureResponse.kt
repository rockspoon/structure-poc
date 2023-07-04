package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Response with the business entity signing envelope id
 *
 * @param envelopeId
 */
@Serializable
data class StartSignatureResponse(
    val envelopeId: String? = null
)

