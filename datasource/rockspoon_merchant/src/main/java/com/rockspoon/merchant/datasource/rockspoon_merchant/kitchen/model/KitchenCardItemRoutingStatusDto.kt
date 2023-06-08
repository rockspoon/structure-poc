package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.Serializable

@Serializable
data class KitchenCardItemRoutingStatusDto(val routing: String, val status: KitchenCardItemStatusDto)