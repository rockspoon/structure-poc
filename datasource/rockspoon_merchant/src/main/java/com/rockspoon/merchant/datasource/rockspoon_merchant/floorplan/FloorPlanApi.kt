package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PaginationResponseDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models.CreateOrUpdateAssignmentRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models.FloorPlanAssignmentDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models.FloorPlanSectionDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models.FloorPlanSectionWithIndexDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models.IdDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface FloorPlanApi {

	@GET("floor-plan/v1/")
	suspend fun getSectionsByStatuses(
		@Query("page") page: Int,
		@Query("page-size") pageSize: Int,
		@Query("status") statuses: List<String>
	): List<FloorPlanSectionDto>

	@POST("floor-plan/v1/")
	suspend fun createSection(@Body newSection: FloorPlanSectionDto): FloorPlanSectionDto

	@PUT("floor-plan/v1/{sectionId}")
	suspend fun updateSection(
		@Path("sectionId") floorPlanSectionId: String,
		@Body updatedSection: FloorPlanSectionDto
	): FloorPlanSectionDto

	@DELETE("floor-plan/v1/{sectionId}")
	suspend fun deleteSection(@Path("sectionId") floorPlanSectionId: String)

	@PATCH("floor-plan/v1/")
	suspend fun updateFloorPlanSectionsIndex(@Body sectionWithIndex: List<FloorPlanSectionWithIndexDto>)

	@GET("floor-plan/v1/section")
	suspend fun getTableAssignments(): PaginationResponseDto<FloorPlanAssignmentDto>

	@POST("floor-plan/v1/section")
	suspend fun addTableAssignment(@Body createOrUpdateAssignmentRequest: CreateOrUpdateAssignmentRequestDto): IdDto

	@PUT("floor-plan/v1/section/{sectionId}")
	suspend fun updateTableAssignment(
		@Path("sectionId") floorPlanSectionId: String,
		@Body createOrUpdateAssignmentRequest: CreateOrUpdateAssignmentRequestDto
	)
}