package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenericOrderItemCustomerDto(
    val orderCustomerId: String,
    val seatNumber: String?,
    @SerialName("id")
    val customerId: String?,
    val isConsumerApp: Boolean?,
    val name: String?
)
