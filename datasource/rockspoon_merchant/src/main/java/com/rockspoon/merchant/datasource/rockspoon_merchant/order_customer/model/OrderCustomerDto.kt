package com.rockspoon.merchant.datasource.rockspoon_merchant.order_customer.model

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.CarInfoDto
import kotlinx.serialization.Serializable

@Serializable
data class OrderCustomerDto(
	val id: String,
	val profileId: String?,
	val name: String,
	val phoneNumber: String,
	val addresses: List<DeliveryCustomerAddressDto>,
	val image: OrderImageDto?,
	val diningStatistics: OrderingCustomerStatisticsDto?,
	val orderingStatistics: OrderingCustomerTakeoutDeliveryStatisticDto?,
	val cars: List<CarInfoDto>?,
	val loyaltyPoint: Int?
)
