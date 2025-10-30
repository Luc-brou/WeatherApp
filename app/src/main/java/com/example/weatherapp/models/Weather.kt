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
        val condition: Condition,
        @SerializedName("precip_mm") val currentPrecipitation: Double,
        @SerializedName("wind_kph") val wind: Double,
        @SerializedName("wind_dir") val windDirection: String,
        val humidity: Int
    )

    data class Forecast(
        @SerializedName("forecastday") val forecastDays: List<ForecastDay>
    )

    data class ForecastDay(
        val date: String,
        val day: Day
    )

    data class Day(
        @SerializedName("maxtemp_c") val maxTemp: Double,
        @SerializedName("mintemp_c") val minTemp: Double,
        val condition: Condition,
        @SerializedName("totalprecip_mm") val totalPrecipMm: Double,
        @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int,
        @SerializedName("maxwind_kph") val maxWind: Double,
        @SerializedName("avghumidity") val avgHumidity: Int
    )

    data class Condition(
        val text: String,
        val icon: String
    )
}