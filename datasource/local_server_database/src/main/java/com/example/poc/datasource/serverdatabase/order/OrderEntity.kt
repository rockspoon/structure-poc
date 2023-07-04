package com.example.poc.datasource.serverdatabase.order

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    var status: Status = Status.OPEN

) {
    enum class Status {

        OPEN,

        CANCELLED,

        PREPARING,

        READY,

        IN_TRANSIT,

        DELIVERED,

        RETURNED
    }
}