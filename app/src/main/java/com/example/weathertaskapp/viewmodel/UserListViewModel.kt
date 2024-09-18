package com.example.weathertaskapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.weathertaskapp.data.local.UserDatabase
import com.example.weathertaskapp.data.local.UserEntity
import com.example.weathertaskapp.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class UserListViewModel(application: Application) : AndroidViewModel(application) {

        private val userDao = UserDatabase.getDatabase(application).userDao() // Use getApplication() if needed
        private val userRepository = UserRepository(userDao)

    private val _userList = MutableStateFlow<List<UserEntity>>(emptyList())
    val userList: StateFlow<List<UserEntity>> = _userList



    init {
        getUsers()
    }




    private fun getUsers() {
        viewModelScope.launch {

            _userList.value = userRepository.getAllUsers()
        }
    }

    fun addUser(user: UserEntity) {
        viewModelScope.launch {
            userRepository.insertUser(user)
            getUsers()
        }
    }

    fun deleteUser(user: UserEntity) {
        viewModelScope.launch {
            userRepository.deleteUser(user)
            getUsers()
        }
    }
}
