package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param address
 * @param description
 * @param logo
 * @param name
 * @param banner
 * @param operatingEntity
 * @param emails
 * @param phones
 * @param websites
 * @param media
 */
@Serializable
data class GeneralInformationResponse(
    val address: Address? = null,
    val description: String? = null,
    val logo: ImageDTO? = null,
    val name: String? = null,
    val banner: ImageDTO? = null,
    val operatingEntity: OperatingEntityDTO? = null,
    val emails: List<String>? = null,
    val phones: List<Phone>? = null,
    val websites: List<Website>? = null,
    val media: List<Media>? = null
)

