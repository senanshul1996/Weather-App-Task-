package com.example.weathertaskapp.data.remote



import com.example.weathertaskapp.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("onecall")
    suspend fun getWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String = "imperial",
        @Query("appid") apiKey: String
    ): Response<WeatherResponse>
}
