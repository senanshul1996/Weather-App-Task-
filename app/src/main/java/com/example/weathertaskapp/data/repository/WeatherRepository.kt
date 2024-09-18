package com.example.weathertaskapp.data.repository


import com.example.weathertaskapp.data.model.WeatherResponse
import com.example.weathertaskapp.data.remote.WeatherApi
import retrofit2.Response

class WeatherRepository(private val api: WeatherApi) {
    suspend fun getWeather(lat: String, lon: String): Response<WeatherResponse> {
        return api.getWeatherData(lat, lon, "imperial","b143bb707b2ee117e62649b358207d3e")
    }
}



