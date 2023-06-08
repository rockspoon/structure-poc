package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

class CartItemActionRequestDto(
    val itemInstanceId: Long,
    val reason: String?,
    val description: String?
) {

    companion object {
        const val WRONG_ORDER = "wrong_order"
        const val CUSTOMER_CHANGED_HIS_MIND = "customer_changed_his_mind"
        const val NOT_AVAILABLE = "not_available"
        const val SERVER_ERROR = "server_error"
        const val OTHER = "other"

        const val CUSTOMER_NOT_SATISFIED = "customer_not_satisfied"
        const val BIRTHDAY_ANNIVERSARY = "birthday_anniversary"
        const val FRIEND = "friend"
    }

    sealed class Reason(val value: String) {
        sealed class Void(reason: String) : Reason(reason) {
            class WrongOrder : Void(WRONG_ORDER)
            class CustomerChangedHisMind : Void(CUSTOMER_CHANGED_HIS_MIND)
            class NotAvailable : Void(NOT_AVAILABLE)
        }

        sealed class Comp(reason: String) : Reason(reason) {
            class CustomerNotSatisfied : Comp(CUSTOMER_NOT_SATISFIED)
            class BirthdayAnniversary : Comp(BIRTHDAY_ANNIVERSARY)
            class Friend : Comp(FRIEND)
        }

        class ServerError : Reason(SERVER_ERROR)
        data class Other(val customReason: String) : Reason(customReason)
    }
}
