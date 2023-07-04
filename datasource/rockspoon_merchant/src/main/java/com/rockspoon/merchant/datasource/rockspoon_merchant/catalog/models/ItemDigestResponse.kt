/**
 * catalog | Error | Code | |
 * ----------------------------------------------------------------------
 * | - | | itemCodePrefix | 4050 | | codeRequiredParameter |
 * 1 | | codeNotEmptyList | 2 | | codeInvalidParameter | 3 |
 * | codeNotfoundSection | 4 | | codeNotfoundModifier | 5 | |
 * codeInactiveItemModifier | 6 | | codeTenantNotAllowed | 7 | |
 * codeNilContext | 8 | | codeDatabaseError | 9 | | codeControllerError
 * | 10 | | codeInvalidHex | 11 | | codeTransformerError | 12 | |
 * codeTranslationError | 13 | | codeAlreadyPublishedError | 14 | |
 * codeAlreadyUnpublishedError | 15 | | codeInvalidContext | 16 | |
 * codeTranslationNotFound | 17 | | oneOrMoreImagesFailedToUpload
 * | 18 | | invalidMicroserviceResponse | 19 | | invalidFacet | 20
 * | | errorCountingItemsFacet | 21 | | errorListingItemsFacet |
 * 22 | | errListingModifiers | 23 | | errorCountingModifiers | 24
 * | | errorCreatingRecipe | 25 | | errorUpdatingRecipe | 26 | |
 * codeNotfoundRecipes | 27 | | itemDoesntHaveInventoryAttributes
 * | 28 | | invalidTag | 29 | | errorListingTags | 30 | |
 * couldNotDeleteItemRecipe | 31 | | couldNotCountItemProperties
 * | 32 | | couldNotGetItemProperties | 33 | | databaseNotFound
 * | 34 | | couldNotRemoveSizes | 35 | | cannotSendSSE | 36 | |
 * actionIsNotAllowedForObjectType | 37 | | actionIsAllowedOnlyFor | 38
 * | | couldNotFindBundleSection | 39 | | couldNotFindBundleItem | 40 |
 * | sizeDoesNotBelongToItem | 41 | | errorListingItemsApprovalStatus |
 * 42 | | errorCountingItemsApprovalStatus | 43 | | errorVisibilityChange
 * | 44 | | errorInvalidRequest | 45 | | menuVersionIsNil | 46
 * | | eCommerceItemAlreadyExists | 47 | | wrongSliceLength |
 * 48 | | deviceMarketplaceVenue | 49 | | decodeBody | 50 | |
 * errorVisibilityStatus | 51 | | couldNotGetExternalMenu | 52 | |
 * couldNotFindVenue | 53 |
 *
 * OpenAPI spec version: v1
 *
 * NOTE: This class is auto generated by the swagger code generator
 * program. https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models

import kotlinx.serialization.Serializable

/**
 * ItemDigestResponse is an item digest response
 *
 * @param category
 * @param course
 * @param index
 * @param nutritionalAttributes
 * @param description
 * @param itemId
 * @param modifiers
 * @param photos
 * @param sizesAndPrices
 * @param subcategory
 * @param tags
 * @param title
 * @param isAvailable
 * @param unavailabilityReason
 * @param bundleAttributes
 * @param meta
 * @param routing
 */
@Serializable
data class ItemDigestResponse(
    val category: ItemType,
    val course: Long,
    val index: Long,
    val nutritionalAttributes: List<NutritionalAttributeResponse>,
    val itemId: String,
    val modifiers: List<ModifierDigestResponse>,
    val photos: List<ImageDto>,
    val sizesAndPrices: List<SizeAndPriceDigestResponse>,
    val subcategory: ItemSubtype,
    val tags: List<String>,
    val title: String,
    val isAvailable: Boolean,
    val description: String? = null,
    val unavailabilityReason: String? = null,
    val bundleAttributes: BundleAttributesDigestResponse? = null,
    val meta: DeviceMeta? = null,
    val routing: List<String>? = null
)

