/**
 * order | Error | Code | |
 * ----------------------------------------------------------------------
 * | - | | errorPrefix | 4150 | | customDatabaseError | 2 | | decodeBody
 * | 3 | | tenantNotAllowed | 6 | | invalidDiscountAction | 9 | |
 * discountAlreadyAdded | 10 | | orderItemWithoutDiscount | 12 | |
 * invalidMiddlewareContext | 14 | | incorrectCurrentStatus | 21 | |
 * orderShouldHaveBalanceZero | 23 | | orderShouldNotHavePayments |
 * 24 | | invalidMicroserviceResponse | 25 | | itemNotFoundInCheck
 * | 26 | | firedTwiceOrderItem | 27 | | dineInOrderFoundNotBeNil
 * | 31 | | cannotReassignToSameWaiter | 32 | | invalidParameter
 * | 34 | | requiredParameter | 36 | | badRequest | 37 | |
 * orderCustomerNotBeNil | 38 | | floorPlanElementAlreadyInUse | 40 | |
 * floorPlanAndOrderTypeNotConform | 41 | | restaurantItemNotFoundItem |
 * 43 | | cardCannotBeEmpty | 44 | | orderItemDoesNotBelongToOrder | 45
 * | | employeeNotAllowedReassignOrder | 46 | | cardRequestCreationError
 * | 47 | | invalidDiscountType | 49 | | cannotApplyDiscountType
 * | 50 | | dinerNotFound | 51 | | notSameOrderID | 52 | |
 * elementDoesNotExistError | 55 | | invalidUnfireStatus | 56
 * | | currencyUnavailable | 57 | | entryTypeNotFound | 58 |
 * | doesNotHanlderMutipleDiscountOrTaxOnSingleEntry | 59 | |
 * dinersDoNotMatchSeats | 60 | | originOrdersDontHaveChecks
 * | 61 | | orderShouldBeOpen | 62 | | noMultipleDiscounts |
 * 63 | | itemIDFoundNotBeNil | 64 | | checkNotFound | 65 | |
 * amountTypeNotFound | 67 | | entryDiscountShouldBeNegative | 68 | |
 * amountCannotBeNil | 69 | | orderDontHaveChecks | 70 | | noOrdersFound
 * | 71 | | couldNotSendEmail | 72 | | couldNotSendSms | 73 | |
 * multipleSecurityDeposit | 74 | | invalidMicroserviceError | 75 | |
 * userProfileNotFound | 76 | | paymentNotFound | 77 | | venueNotFound
 * | 78 | | venueDoNotDelivery | 79 | | invalidVenueDeliveryInfo |
 * 80 | | itemNotInDineinOrder | 81 | | orRequiredParameters | 83
 * | | invalidOrderType | 84 | | errorCountingCustomersPhoneNumber
 * | 85 | | errorListingCustomersPhoneNumber | 86 | |
 * deleteTableCheck | 87 | | checkNotRelatedToOrder | 88 | |
 * tooManyAddressToDelivery | 90 | | scheduledForBeforeCurrentTime |
 * 92 | | errorRetrievingRestaurantOrderItemsByOrderIdsAndItemStatus
 * | 93 | | errorRetrievingRestaurantOrderItemsByOrderIds |
 * 94 | | invalidTimeInterval | 96 | | checkEntryNotFound
 * | 97 | | invalidEntryType | 98 | | invalidCheckType
 * | 99 | | couldNotGetGenericOrderByOrderID | 101
 * | | couldNotGetAllOrderItemsByOrderID | 102 | |
 * couldNotUpdateUnfireOrderItems | 104 | | invalidCheckEntry |
 * 105 | | genericOrderFoundNotBeNil | 107 | | tooLateForEdit |
 * 108 | | refundNotFound | 109 | | couldNotGetOccupancy | 110
 * | | userHaveOpenOrder | 111 | | controllerError | 112 | |
 * customerNotFound | 113 | | addressNotFound | 117 | | invalidHexError
 * | 118 | | invalidRequestError | 119 | | timeParseError | 120 | |
 * errorCreatingVenueSettings | 121 | | errorUpdatingVenueSettings | 122 |
 * | errorUpsertingVenueSettings | 123 | | errorGettingVenueSettings | 124
 * | | findOrderForCheck | 126 | | wrongCardData | 127 | | translationError
 * | 128 | | bagNotFoundInOrder | 129 | | couldNotUpdateOrder |
 * 135 | | cannotCancelOrder | 136 | | notFullyRefunded | 137 | |
 * cannotGetOrderCards | 138 | | couldNotCreateConsumerAppOrder | 139 | |
 * wrongOrderTypeScheduledFor | 140 | | securityDepositNotFound | 142 |
 * | newCheckSummary | 143 | | errorListingCustomersByPhoneNumberOrName
 * | 144 | | bagNotFoundInGenericOrder | 146 | | orderTypeNotSupportBags
 * | 147 | | cannotSendSSE | 148 | | noBagsInOrder | 149 | |
 * couldNotRemoveBag | 150 | | totalBillIsLessThanOrderMinimumAmount |
 * 152 | | wrongOrderTypeForPrintBagReceipts | 153 | | emptyDiners | 154
 * | | itemsNotInMenuForOrderType | 155 | | notFoundVenueSettings | 156
 * | | checkExistThirdParty | 157 | | couldNotAddBundleOrderItem | 158 |
 * | couldNotFindBundleItem | 159 | | wrongEntryDiscountAmount | 160 | |
 * orderAmountCannotBeNegative | 161 | | couldNotFindRestaurantBundleItem
 * | 162 | | couldNotRemoveRestaurantBundleItem | 163 | |
 * couldNotFindSizeResponse | 164 | | wrongCAPaymentType | 165 | |
 * wrongDinerRequest | 166 | | couldNotFindOneOfBundleItems | 167
 * | | couldNotCloseDinerSeat | 168 | | cartCommitError | 169 |
 * | invalidDeleteCartItemsParameters | 170 | | invalidCCToken |
 * 171 | | errCapturePayment | 172 | | undeterminedCheckStatus |
 * 173 | | wrongDomain | 174 | | invalidDownpaymentAmount | 175 |
 * | couldNotPlaceOrder | 176 | | thirdPartIntegration | 177 | |
 * couldNotPrintQSROrder | 178 | | couldNotAmortizePayment | 179 | |
 * orderItemsUnavailable | 180 | | discountsAreOverCheckTotal | 181
 * | | employeeNotClockedIn | 182 | | floorPlanIsNotPublished | 183
 * | | emptyVenueIDForDeviceMarkeplace | 184 | | seatAlreadyOccupied
 * | 185 | | couldNotFindRoutings | 186 | | customerCarNotFound |
 * 187 | | checkWithoutCustomerInfo | 188 | | accessDenied | 189 | |
 * thirdPartyOrderPaymentRefund | 190 | | cannotVoidSplittedItem | 191
 * | | payOnPaperIsDisabled | 192 | | wrongPaymentServiceType | 193 |
 * | shadowUserAction | 194 | | couldNotFetchCheckByCheckID | 195 | |
 * couldNotUpdateCheckOrder | 196 | | couldNotFindCheckOrderByOrderID |
 * 197 | | couldNotDeleteEntries | 198 | | couldNotGetCustomers | 199
 * | | couldNotUpdateDinerpayment | 200 | | invalidPageToken | 201 | |
 * couldNotUpdateCheckByCheckID | 202 | | couldNotFetchCheckByOrderItemID
 * | 203 | | couldNotFetchCheckOfTheTableByOrderID | 204 | |
 * deletePaidOrAwaitingPaymentCheck | 205 | | cannotMoveCheckEntries |
 * 206 | | deleteSeatWithPaidCheck | 207 | | guestNotFoundInOrder | 208 |
 *
 * OpenAPI spec version: v1
 *
 * NOTE: This class is auto generated by the swagger code generator
 * program. https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

/**
 * represents a discount to specific check request model
 *
 * @param type
 * @param reason
 * @param orderItemId
 * @param value
 */
@Serializable
data class DiscountCheckRequest(
    val type: AmountType,
    val reason: String,
    @Serializable(with = BigDecimalSerializer::class)
    val value: BigDecimal,
    val orderItemId: String? = null
)

