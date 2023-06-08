package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param ein EIN can be several different types (state id number, SSN,
 *     etc)
 * @param legalEntityName businesses legal name
 */
@Serializable
data class CompanyInformationRequest(
    /** EIN can be several different types (state id number, SSN, etc) */
    val ein: String? = null,
    /** businesses legal name */
    val legalEntityName: String? = null
)

