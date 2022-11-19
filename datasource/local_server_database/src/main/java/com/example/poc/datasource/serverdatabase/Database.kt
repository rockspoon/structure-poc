package com.example.poc.datasource.serverdatabase

import androidx.room.RoomDatabase
import com.example.poc.datasource.serverdatabase.order.OrderDao
import com.example.poc.datasource.serverdatabase.order.OrderEntity
import com.example.poc.datasource.serverdatabase.user.UserDao
import com.example.poc.datasource.serverdatabase.user.UserEntity

@androidx.room.Database(
    version = 1,
    entities = [
        OrderEntity::class,
        UserEntity::class
    ]
)
abstract class Database : RoomDatabase() {

    abstract fun orderDao(): OrderDao

    abstract fun userDao(): UserDao
}