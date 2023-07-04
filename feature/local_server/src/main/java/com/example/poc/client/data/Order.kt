package com.example.poc.client.data

data class Order(

    var id: Long? = null,

    // Simple implementation. In a production application I would have a list to log
    // all changes in status, with their timestamp and etc.
    var status: Status

) {
    enum class Status {

        OPEN,

        PREPARING,

        READY,

        IN_TRANSIT,

        /**
         * Represent orders that were not delivered but cancelled.
         */
        CANCELLED,

        DELIVERED,

        /**
         * Represent orders that were delivered but returned because of defect.
         */
        RETURNED
    }
}