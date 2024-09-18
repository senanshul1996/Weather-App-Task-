package com.example.weathertaskapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(

    @SerializedName("lat") val lat: Double,
@SerializedName( "lon") val lon: Double,
@SerializedName( "timezone") val timezone: String,
@SerializedName( "timezone_offset") val timezoneOffset: Int,
@SerializedName( "current") val current: Current,
@SerializedName( "minutely") val minutely: List<Minutely>,
@SerializedName( "hourly") val hourly: List<Hourly>
)
data class Current(
    @SerializedName( "dt") val dt: Long,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName( "sunset") val sunset: Long,
    @SerializedName( "temp") val temp: Double, //show
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName( "humidity") val humidity: Int,
    @SerializedName("dew_point") val dewPoint: Double,
    @SerializedName( "uvi") val uvi: Double,
    @SerializedName( "clouds") val clouds: Int,
    @SerializedName( "visibility") val visibility: Int,
    @SerializedName( "wind_speed") val windSpeed: Double,
    @SerializedName("wind_deg") val windDeg: Int,
    @SerializedName("weather") val weather: List<Weather>
)
data class Weather(
    @SerializedName("id") val id: Int,
    @SerializedName( "main") val main: String,
    @SerializedName( "description") val description: String,
    @SerializedName( "icon") val icon: String
)
data class Minutely(
    @SerializedName("dt") val dt: Long,
    @SerializedName( "precipitation") val precipitation: Double
)

data class Hourly(
    @SerializedName( "dt") val dt: Long,
    @SerializedName( "temp") val temp: Double, //show
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName( "humidity") val humidity: Int, //show
    @SerializedName( "dew_point") val dewPoint: Double,
    @SerializedName( "uvi") val uvi: Double,
    @SerializedName( "clouds") val clouds: Int,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName( "wind_speed") val windSpeed: Double, //show
    @SerializedName("wind_deg") val windDeg: Int,
    @SerializedName("wind_gust") val windGust: Double,
    @SerializedName("weather") val weather: List<Weather>, //show
    @SerializedName( "pop") val pop: Double
)