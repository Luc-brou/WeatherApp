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
        @SerializedName("tempC") val currentTemp: Double,
        val condition: CurrentCondition,
        @SerializedName("precipMm") val current_precipitation: Double,
        @SerializedName("windKph") val wind: Double,
        @SerializedName("windDir") val wind_direction: String,
        val humidity: Int
    )

    data class CurrentCondition(
        val text: String,
        val icon: String
    )

    data class Forecast(
        @SerializedName("forecastday") val forecastDays: List<ForecastDay>
    )

    data class ForecastDay(
        val date: String,
        val day: Day
    )

    data class Day(
        val maxTempC: Double,
        val minTempC: Double,
        val condition: Condition,
        val totalPrecipMm: Double,
        val dailyChanceOfRain: Int,
        val maxWindKph: Double,
        val avgHumidity: Int
    )

    data class Condition(
        val text: String,
        val icon: String
    )
}