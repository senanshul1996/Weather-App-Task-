package com.example.weathertaskapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertaskapp.data.model.WeatherResponse
import com.example.weathertaskapp.data.remote.RetrofitInstance
import com.example.weathertaskapp.data.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

    class WeatherViewModel() : ViewModel() {

    private val weatherRepository = WeatherRepository(RetrofitInstance.api)

    private val _weatherData = MutableStateFlow<WeatherResponse?>(null)
    val weatherData: StateFlow<WeatherResponse?> = _weatherData




    fun fetchWeather(lat: String, lon: String) {
        viewModelScope.launch {
            val response = weatherRepository.getWeather(lat, lon)
            if (response.isSuccessful) {
                _weatherData.value = response.body()
                Log.e("WeatherViewModel", "Weather Data Updated: ${_weatherData.value}")
            }else{
                Log.e("WeatherViewModel", "Failed to fetch weather data: ${response.errorBody()?.string()}")
            }
        }
    }
}
