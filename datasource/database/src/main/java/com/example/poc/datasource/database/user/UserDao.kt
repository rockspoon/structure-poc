package com.example.poc.datasource.database.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserDao {

    @Query("select * from UserEntity where id = :id")
    abstract suspend fun get(id: Long): UserEntity

    @Query("select * from UserEntity where id = :id")
    abstract fun observe(id: Long): Flow<UserEntity>

    @Insert(onConflict = REPLACE)
    abstract suspend fun insert(entity: UserEntity): Long
}