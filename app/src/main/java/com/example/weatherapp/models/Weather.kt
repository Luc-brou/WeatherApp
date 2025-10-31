package com.example.weatherapp.models

import com.google.gson.annotations.SerializedName

data class Weather( //These all scaffold/nest to mirror the JSON data the app is fetching.
    val location: Location,
    val current: Current,
    val forecast: Forecast
) {
    data class Location( //location model
        val name: String,
        val region: String,
        val country: String
    )

    data class Current( //current model
        @SerializedName("temp_c") val currentTemp: Double,
        val condition: Condition, //points to condition model further down in this file
        @SerializedName("precip_mm") val currentPrecipitation: Double,
        @SerializedName("wind_kph") val wind: Double,
        @SerializedName("wind_dir") val windDirection: String,
        val humidity: Int
    )

    data class Forecast(
        @SerializedName("forecastday") val forecastDays: List<ForecastDay> //points to forecast model
    )                                                                             //further down the list

    data class ForecastDay(
        val date: String,
        val day: Day
    )

    data class Day(
        @SerializedName("maxtemp_c") val maxTemp: Double,
        @SerializedName("mintemp_c") val minTemp: Double,
        val condition: Condition, //both these point to data class condition. no need to repeat the same block twice.
        @SerializedName("totalprecip_mm") val totalPrecipMm: Double,
        @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int,
        @SerializedName("maxwind_kph") val maxWind: Double,
        @SerializedName("avghumidity") val avgHumidity: Int
    )

    data class Condition( //here is condition data model used for both "condition" properties
        val text: String,
        val icon: String
    )
}