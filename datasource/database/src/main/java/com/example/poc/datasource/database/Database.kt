package com.example.poc.datasource.database

import androidx.room.RoomDatabase
import com.example.poc.datasource.database.order.OrderDao
import com.example.poc.datasource.database.order.OrderEntity
import com.example.poc.datasource.database.user.UserDao
import com.example.poc.datasource.database.user.UserEntity

@androidx.room.Database(
    version = 2,
    entities = [
        OrderEntity::class,
        UserEntity::class
    ]
)
abstract class Database : RoomDatabase() {

    abstract fun orderDao(): OrderDao

    abstract fun userDao(): UserDao
}