package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param imageId */
@Serializable
data class UpdateGeneralInformationLogoRequest(
    val imageId: String? = null
)

