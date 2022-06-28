package com.example.poc.datasource.serverdatabase.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    /**
     *
     */
    var email: String? = null,

    var givenName: String? = null,

    var familyName: String? = null,

    var password: String? = null
)