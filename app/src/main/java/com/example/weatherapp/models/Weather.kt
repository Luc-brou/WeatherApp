package com.example.weatherapp.models

import com.google.gson.annotations.SerializedName

data class Weather(
    val location: Location,
    val current: Current,
    val forecast: Forecast
) {
    data class Location(
        val name: String,
        val region: String,
        val country: String
    )

    data class Current(
        @SerializedName("temp_c") val currentTemp: Double,
        val condition: condition,
        @SerializedName("precip_mm") val current_precipitation: Double,
        @SerializedName("wind_kph") val wind: Double,
        @SerializedName("wind_dir") val wind_direction: String,
        val humidity: Int
    )

    data class Forecast(
        @SerializedName("forecastday") val forecastDays: List<forecastday>
    )

    data class forecastday(
        val date: String,
        val day: day
    )

    data class day(
        val maxtemp_C: Double,
        val mintemp_C: Double,
        val condition: condition,
        val totalprecip_Mm: Double,
        val daily_chance_of_rain: Int,
        val maxwind_kph: Double,
        val avghumidity: Int
    )

    data class condition(
        val text: String,
        val icon: String
    )
}