package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class QuantityStepDetailsDto(
    @SerialName("quantity")
    @Serializable(with = BigDecimalSerializer::class)
    val minStep: BigDecimal?,
    val unit: String?
)
