package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PriceDto
import kotlinx.serialization.Serializable

/**
 * @param address
 * @param annualClosures
 * @param availableSalesOptions
 * @param cateringServices
 * @param propertyDescription
 * @param deliveryServices
 * @param description
 * @param images
 * @param logo
 * @param maxPrice
 * @param minPrice
 * @param name
 * @param banner
 * @param tenantId
 * @param code
 * @param openingHours
 * @param phones
 * @param scheduledClosures
 * @param websites
 * @param giftCardOptions
 * @param deviceConfig
 */
@Serializable
data class VenuePublicInfo(
    val address: Address? = null,
    val annualClosures: List<AnnualClosuresDTO>? = null,
    val availableSalesOptions: SalesOptions? = null,
    val cateringServices: CateringServices? = null,
    val propertyDescription: PropertyDescription? = null,
    val deliveryServices: DeliveryServices? = null,
    val description: String? = null,
    val images: List<GalleryImageDTO>? = null,
    val logo: ImageDTO? = null,
    val maxPrice: PriceDto? = null,
    val minPrice: PriceDto? = null,
    val name: String? = null,
    val banner: ImageDTO? = null,
    val tenantId: String? = null,
    val code: String? = null,
    val openingHours: List<OpeningHours>? = null,
    val phones: List<Phone>? = null,
    val scheduledClosures: ScheduledClosure? = null,
    val websites: List<Website>? = null,
    val giftCardOptions: GiftCardOptionsDTO? = null,
    val deviceConfig: DeviceConfig? = null
)

