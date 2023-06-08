package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param serviceModel
 * @param categories
 * @param parkingAddresses
 * @param restaurantFeatures
 * @param propertyTypes
 * @param paymentMethods
 * @param facilities
 * @param cuisines
 */
@Serializable
data class PropertyDescription(
    val serviceModel: ServiceModel? = null,
    val categories: List<String>? = null,
    val parkingAddresses: List<VenueParkingDTO>? = null,
    val restaurantFeatures: List<String>? = null,
    val propertyTypes: List<String>? = null,
    val paymentMethods: List<String>? = null,
    val facilities: List<String>? = null,
    val cuisines: List<String>? = null
) {

    /** Values: counter,table,both */
    @Serializable
    enum class ServiceModel(val value: String) {

        @SerialName("counter")
        COUNTER("counter"),

        @SerialName("table")
        TABLE("table"),

        @SerialName("both")
        BOTH("both");

    }

}

