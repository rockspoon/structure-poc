package com.example.poc.datasource.database.order

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class OrderEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
)