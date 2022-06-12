package com.example.poc.datasource.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val givenName: String? = null,

    val familyName: String? = null,

    val password: String? = null
)