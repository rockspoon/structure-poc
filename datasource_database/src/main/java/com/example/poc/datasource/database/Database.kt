package com.example.poc.datasource.database

import androidx.room.RoomDatabase
import com.example.poc.datasource.database.user.UserDao
import com.example.poc.datasource.database.user.UserEntity

@androidx.room.Database(
    version = 2,
    entities = [
        UserEntity::class
    ]
)
abstract class Database : RoomDatabase() {

    abstract fun userDao(): UserDao
}