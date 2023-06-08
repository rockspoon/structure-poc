package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen

import com.rockspoon.merchant.datasource.rockspoon_merchant.HEADER_NO_ACCESS_TOKEN
import com.rockspoon.merchant.datasource.rockspoon_merchant.HEADER_URL_PATH
import com.rockspoon.merchant.datasource.rockspoon_merchant.HEADER_USER_INTERACTION_UUID
import com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model.KitchenCardDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model.KitchenCardItemSummaryDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model.PrintPayloadRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model.UpdateKitchenCardItemStatusDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model.UpdateKitchenCardItemStatusRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model.UpdateKitchenCardItemWorkstationsRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model.UpdateKitchenCardRequestDto
import kotlinx.datetime.Instant
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

private const val KITCHEN_DISPLAY_CARD_PATH = "kitchen-display/v1/card"
private const val KITCHEN_DISPLAY_CARD_ITEM_PATH = "kitchen-display/v1/card-item"
private const val KITCHEN_DISPLAY_CARD_UPDATE_ITEM_PATH =
	"kitchen-display/v1/card-item/{cardItemId}"
private const val KITCHEN_DISPLAY_CARD_PRINT_PATH = "kitchen-display/v1/card/{cardId}/print"

interface KitchenDisplayV1Api {

	@Headers(HEADER_URL_PATH + KITCHEN_DISPLAY_CARD_PATH, HEADER_NO_ACCESS_TOKEN)
	@GET(KITCHEN_DISPLAY_CARD_PATH)
	suspend fun getCards(
		@Header(HEADER_USER_INTERACTION_UUID) uuidEvent: String? = null,
		@Query("cardTypes") cardTypes: List<String>?,
		@Query("status") status: List<String>?,
		@Query("group") group: String?,
		@Query("orderId") orderIds: List<String>?
	): List<KitchenCardDto>

	@Headers(HEADER_URL_PATH + KITCHEN_DISPLAY_CARD_PATH)
	@POST(KITCHEN_DISPLAY_CARD_PATH)
	suspend fun updateCard(@Body request: UpdateKitchenCardRequestDto)

	@SuppressWarnings("LongParameterList")
	@Headers(HEADER_URL_PATH + KITCHEN_DISPLAY_CARD_ITEM_PATH, HEADER_NO_ACCESS_TOKEN)
	@GET(KITCHEN_DISPLAY_CARD_ITEM_PATH)
	suspend fun getCardItemSummary(
		@Query("fromScheduledFor") fromScheduledFor: Instant?,
		@Query("toScheduledFor") toScheduledFor: Instant?,
		@Query("cardTypes") cardTypes: Set<String>?,
		@Query("status") status: Set<String>?,
		@Query("orderId") orderIds: List<String>?,
		@Query("includeArchived") includeArchived: Boolean
	): List<KitchenCardItemSummaryDto>

	@Headers(HEADER_URL_PATH + KITCHEN_DISPLAY_CARD_ITEM_PATH, HEADER_NO_ACCESS_TOKEN)
	@DELETE(KITCHEN_DISPLAY_CARD_ITEM_PATH)
	suspend fun deleteCardItems(@Query("cardItemId") cardIds: List<String>)

	@Headers(HEADER_URL_PATH + KITCHEN_DISPLAY_CARD_ITEM_PATH, HEADER_NO_ACCESS_TOKEN)
	@PUT(KITCHEN_DISPLAY_CARD_ITEM_PATH)
	suspend fun updateCardItemStatus(
		@Body request: UpdateKitchenCardItemStatusRequestDto
	): List<UpdateKitchenCardItemStatusDto>

	@Headers(HEADER_URL_PATH + KITCHEN_DISPLAY_CARD_UPDATE_ITEM_PATH, HEADER_NO_ACCESS_TOKEN)
	@PATCH(KITCHEN_DISPLAY_CARD_UPDATE_ITEM_PATH)
	suspend fun updateCardItemWorkstations(
		@Path("cardItemId") deviceId: String,
		@Body request: UpdateKitchenCardItemWorkstationsRequest
	)

	@Headers(HEADER_URL_PATH + KITCHEN_DISPLAY_CARD_PRINT_PATH, HEADER_NO_ACCESS_TOKEN)
	@POST(KITCHEN_DISPLAY_CARD_PRINT_PATH)
	suspend fun printKitchenOrder(
		@Path("cardId") cardId: String,
		@Body request: PrintPayloadRequest
	)
}