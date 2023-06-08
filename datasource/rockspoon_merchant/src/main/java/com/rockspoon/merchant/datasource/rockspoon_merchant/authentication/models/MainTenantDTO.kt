package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param backgroundCheck
 * @param bankingInfo
 * @param bikeDelivery
 * @param carDelivery
 * @param driversLicense
 * @param driversLicenseNumber
 * @param firstName
 * @param lastName
 * @param personalShopper
 * @param roles
 * @param socialSecurityNumber
 * @param tenantID
 */
@Serializable
data class MainTenantDTO(
    val backgroundCheck: Map<String, String>? = null,
    val bankingInfo: BankingInfo? = null,
    val bikeDelivery: Boolean? = null,
    val carDelivery: Boolean? = null,
    val driversLicense: List<ImageDTO>? = null,
    val driversLicenseNumber: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val personalShopper: Boolean? = null,
    val roles: List<MainTenantRoleDTO>? = null,
    val socialSecurityNumber: String? = null,
    val tenantID: String? = null
)

