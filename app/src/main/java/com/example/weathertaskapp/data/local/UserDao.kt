package com.example.weathertaskapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<UserEntity>



   // @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    suspend fun insertUser(user: UserEntity) : Unit

    @Delete
    suspend fun deleteUser(user: UserEntity)
}