package com.example.weathertaskapp.data.repository


import com.example.weathertaskapp.data.local.UserDao
import com.example.weathertaskapp.data.local.UserEntity

class UserRepository(private val userDao: UserDao) {


    suspend fun getAllUsers() = userDao.getAllUsers()
    suspend fun insertUser(user: UserEntity) = userDao.insertUser(user)
    suspend fun deleteUser(user: UserEntity) = userDao.deleteUser(user)
}
