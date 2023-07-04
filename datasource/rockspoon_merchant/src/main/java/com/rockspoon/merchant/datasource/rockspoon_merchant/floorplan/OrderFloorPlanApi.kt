package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan

import com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models.FloorPlanSectionWithOrderDto
import retrofit2.http.GET

interface OrderFloorPlanApi {

	// TODO This is part of the OrderApi as it's in URL ("order/v1"), there is no microservice for
	// order floor plan.
	@GET("order/v1/dine-in/floor-plan")
	suspend fun getOrderFloorPlan(): List<FloorPlanSectionWithOrderDto>
}