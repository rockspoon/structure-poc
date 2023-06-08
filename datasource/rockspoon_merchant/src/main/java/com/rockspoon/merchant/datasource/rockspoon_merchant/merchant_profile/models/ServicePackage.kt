package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param baseFees
 * @param cost
 * @param hasMenuRSGo
 * @param includesAnalytics
 * @param includesDeliveryAndTakeout
 * @param includesHumanResources
 * @param includesInventoryManagement
 * @param includesPOSSolution
 * @param includesPayments
 * @param includesRSGoOrders
 * @param includesReservationsWaitlist
 * @param includesSalesReport
 * @param isVisibleRSGo
 * @param name
 * @param products
 */
@Serializable
data class ServicePackage(
    val baseFees: List<Fee>? = null,
    val cost: String? = null,
    val hasMenuRSGo: Boolean? = null,
    val includesAnalytics: Boolean? = null,
    val includesDeliveryAndTakeout: Boolean? = null,
    val includesHumanResources: Boolean? = null,
    val includesInventoryManagement: Boolean? = null,
    val includesPOSSolution: Boolean? = null,
    val includesPayments: Boolean? = null,
    val includesRSGoOrders: Boolean? = null,
    val includesReservationsWaitlist: Boolean? = null,
    val includesSalesReport: Boolean? = null,
    val isVisibleRSGo: Boolean? = null,
    val name: String? = null,
    val products: List<Product>? = null
)

