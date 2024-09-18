package com.example.weathertaskapp.viewmodel



import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertaskapp.data.local.UserDatabase
import com.example.weathertaskapp.data.local.UserEntity
import com.example.weathertaskapp.data.repository.UserRepository
import kotlinx.coroutines.launch


class UserFormViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = UserDatabase.getDatabase(application).userDao()
    private val userRepository = UserRepository(userDao)

    fun saveUser(user: UserEntity, onSuccess: () -> Unit) {
        viewModelScope.launch {
            userRepository.insertUser(user)
            onSuccess()
        }
    }
}
