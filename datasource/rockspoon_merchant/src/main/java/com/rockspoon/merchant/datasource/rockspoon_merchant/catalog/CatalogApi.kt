package com.rockspoon.merchant.datasource.rockspoon_merchant.catalog

import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.ImageInfo
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.ItemResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.ItemsPagination
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.ListItemModifierResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.MenuDigestResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.PatchItemRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.RecipeResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.RoutingRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.RoutingResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.UpdateItemAvailabilityRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CatalogApi {

    /**
     * Get menu digest for consumer Get menu digest for consumer. Returns only
     * published menus.
     */
    @GET("catalog/v1/menu/digest")
    suspend fun getMenuDigest(
        @Query("statusName") statusName: String?,
        @Query("itemId") itemId: List<String>?,
        @Query("allowExternal") allowExternal: Boolean?
    ): List<MenuDigestResponse>

    /** Get item routings. */
    @GET("catalog/v1/item/routing")
    suspend fun getItemRouting(
        @Query("itemId") itemId: List<String>?,
        @Query("menuId") menuId: List<String>?,
        @Query("sectionId") sectionId: List<String>?
    ): List<RoutingResponse>

    /** Set item routing. */
    @PUT("catalog/v1/item/routing")
    suspend fun setItemRouting(
        @Body request: List<RoutingRequest>
    )

    /** List the modifiers of an item in a menu. */
    @GET("catalog/v1/item/{itemId}/modifier")
    suspend fun fetchItemModifiers(
        @Path("itemId") catalogItemId: String
    ): List<ListItemModifierResponse>

    /** Get items with pagination */
    @GET("catalog/v1/item")
    suspend fun listWithPagination(
        @Query("next") next: String?,
        @Query("previous") previous: String?,
        @Query("pageSize") pageSize: Int?,
        @Query("facet") facet: String?,
        @Query("isMarketPrice") isMarketPrice: String?,
        @Query("term") term: String?,
        @Query("id") id: List<String>?,
        @Query("category") category: String?,
        @Query("tag") tag: List<String>?,
        @Query("isRockspoonVenue") isRockspoonVenue: String?,
        @Query("orderBy") orderBy: String?,
        @Query("sortBy") sortBy: String?,
        @Query("withPhoto") withPhoto: String?
    ): ItemsPagination

    @GET("catalog/v1/item/{itemId}")
    suspend fun fetchCatalogItem(
        @Path("itemId") itemId: String,
        @Query("isRockspoonVenue") isRockspoonVenue: String?
    ): ItemResponse

    @PATCH("catalog/v1/item/{itemId}")
    fun updateCatalogItemPrice(
        @Path("itemId") itemId: String,
        @Body request: PatchItemRequest
    )

    @GET("catalog/v1/item/{itemId}/recipe")
    fun fetchRecipe(
        @Path("itemId") itemId: String
    ): RecipeResponse

    @POST("catalog/v1/item/{itemId}/photo")
    fun updateItemPhotos(
        @Path("itemId") itemId: String,
        @Body request: List<ImageInfo>
    )

    @DELETE("catalog/v1/item/{itemId}/photo/{photoId}")
    fun deleteItemPhotos(
        @Path("itemId") itemId: String,
        @Path("photoId") photoId: String
    )

    @PUT("catalog/v1/item/{itemId}/availability")
    fun updateItemAvailability(
        @Path("itemId") itemId: String,
        @Body request: UpdateItemAvailabilityRequest
    )
}
