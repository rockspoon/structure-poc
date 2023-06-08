package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param availableSalesOptions
 * @param cateringServices
 * @param deliveryServices
 * @param extraFees
 * @param serviceCharge
 * @param serviceChargeHistory
 * @param salesTaxRate this field represents the salesTax value for the
 *     currentSalesTax object.
 * @param currentSalesTax
 * @param salesTaxHistory
 * @param salesTax8080Rule
 * @param salesTaxApplyToGo
 */
@Serializable
data class SellingInformationResponse(
    val availableSalesOptions: SalesOptions? = null,
    val cateringServices: CateringServicesRequest? = null,
    val deliveryServices: DeliveryServicesRequest? = null,
    val extraFees: List<SellingInformationRequestExtraFees>? = null,
    val serviceCharge: ServiceCharge? = null,
    val serviceChargeHistory: List<ServiceCharge>? = null,
    /** this field represents the salesTax value for the currentSalesTax object. */
    val salesTaxRate: Double? = null,
    val currentSalesTax: SalesTax? = null,
    val salesTaxHistory: List<SalesTax>? = null,
    val salesTax8080Rule: Boolean? = null,
    val salesTaxApplyToGo: Boolean? = null
)

