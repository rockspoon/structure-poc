package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PriceDto
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param _version
 * @param address
 * @param amenities
 * @param availability
 * @param availableSalesOptions
 * @param bankingInformation
 * @param brand
 * @param calculatedDistance
 * @param capacity
 * @param cateringServices
 * @param companyId
 * @param createdAt
 * @param createdBy
 * @param crm
 * @param deletedAt
 * @param deletedBy
 * @param deliveryServices
 * @param deviceSetup
 * @param deviceConfig
 * @param dineInServices
 * @param hideFromSearch
 * @param id
 * @param images
 * @param maxPrice
 * @param minPrice
 * @param name
 * @param notifications
 * @param operatingEntity
 * @param status
 * @param tags
 * @param tenantCode
 * @param tenantId
 * @param tenantKey
 * @param updatedAt
 * @param updatedBy
 * @param websiteConfig
 * @param type
 * @param marketingData
 */
@Serializable
data class AdminGetVenuesResponse(
    @SerialName("_version")
    val version: Int? = null,
    val address: Address? = null,
    val amenities: AmenitiesDTO? = null,
    val availability: VenueAvailabilityDTO? = null,
    val availableSalesOptions: SalesOptions? = null,
    val bankingInformation: BankingInformation? = null,
    val brand: BrandDTO? = null,
    val calculatedDistance: Double? = null,
    val capacity: Capacity? = null,
    val cateringServices: CateringServices? = null,
    val companyId: Int? = null,
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val crm: VenueCRM? = null,
    val deletedAt: Instant? = null,
    val deletedBy: String? = null,
    val deliveryServices: DeliveryServices? = null,
    val deviceSetup: DeviceSetup? = null,
    val deviceConfig: DeviceConfig? = null,
    val dineInServices: DineInServices? = null,
    val hideFromSearch: Boolean? = null,
    val id: String? = null,
    val images: List<GalleryImageDTO>? = null,
    val maxPrice: PriceDto? = null,
    val minPrice: PriceDto? = null,
    val name: String? = null,
    val notifications: VenueNotification? = null,
    val operatingEntity: OperatingEntityDTO? = null,
    val status: String? = null,
    val tags: List<VenueTag>? = null,
    val tenantCode: String? = null,
    val tenantId: String? = null,
    val tenantKey: TenantKey? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val websiteConfig: WebsiteConfig? = null,
    val type: VenueType? = null,
    val marketingData: VenueMarketingData? = null
)

