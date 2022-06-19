package com.example.poc.server.data


data class Subscriber(

    var id: Long? = null,

    /**
     * An http url to notify the user about the status change
     */
    var webHook: String? = null

)