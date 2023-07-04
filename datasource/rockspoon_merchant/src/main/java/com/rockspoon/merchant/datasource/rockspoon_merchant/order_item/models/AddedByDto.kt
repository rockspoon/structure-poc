package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddedByDto(
    val profileId: String?,
    val type: Type?
) {

    @Serializable
    enum class Type {
        @SerialName("employee")
        EMPLOYEE,

        @SerialName("customer")
        CUSTOMER;
    }
}

