package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param availableSalesOptions
 * @param cateringServices
 * @param deliveryServices
 * @param extraFees
 * @param serviceCharge
 * @param upcomingServiceCharge
 * @param salesTaxRate v1 compatibility field. Please use upcomingSalesTax
 *     instead
 * @param upcomingSalesTax
 * @param salesTax8080Rule
 * @param salesTaxApplyToGo
 */
@Serializable
data class SellingInformationRequest(
    val availableSalesOptions: SalesOptions? = null,
    val cateringServices: CateringServicesRequest? = null,
    val deliveryServices: DeliveryServicesRequest? = null,
    val extraFees: List<SellingInformationRequestExtraFees>? = null,
    val serviceCharge: ServiceCharge? = null,
    val upcomingServiceCharge: ServiceCharge? = null,
    /** v1 compatibility field. Please use upcomingSalesTax instead */
    val salesTaxRate: Double? = null,
    val upcomingSalesTax: SalesTax? = null,
    val salesTax8080Rule: Boolean? = null,
    val salesTaxApplyToGo: Boolean? = null
)

