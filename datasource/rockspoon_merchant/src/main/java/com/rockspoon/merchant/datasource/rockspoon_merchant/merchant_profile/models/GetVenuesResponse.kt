package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PriceDto
import kotlinx.serialization.Serializable

/**
 * @param address
 * @param businessEntityId
 * @param description
 * @param id
 * @param images
 * @param key
 * @param logo
 * @param banner
 * @param maxPrice
 * @param minPrice
 * @param name
 * @param code
 * @param tenantId
 * @param websites
 * @param type
 * @param giftCardOptions
 * @param deviceConfig
 */
@Serializable
data class GetVenuesResponse(
    val address: Address? = null,
    val businessEntityId: String? = null,
    val description: String? = null,
    val id: String? = null,
    val images: List<GalleryImageDTO>? = null,
    val key: String? = null,
    val logo: ImageDTO? = null,
    val banner: ImageDTO? = null,
    val maxPrice: PriceDto? = null,
    val minPrice: PriceDto? = null,
    val name: String? = null,
    val code: String? = null,
    val tenantId: String? = null,
    val websites: List<Website>? = null,
    val type: VenueType? = null,
    val giftCardOptions: GiftCardOptionsDTO? = null,
    val deviceConfig: DeviceConfig? = null
)

