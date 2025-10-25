package com.example.weatherapp.models

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName


data class Weather(
//    val location: Location,
//    val current: Current,
//    val forecast: Forecast
    val current: Current,

    val forecast: List<Forecast>
) {

    data class Location()

    data class Current(
        val temp_c: Double,
        val condition: CurrentCondition,
        val precip_mm: Double,
        val wind_kph: Double,
        val wind_dir: String
    )

    data class CurrentCondition( //couldn't have condition twice
        val text: String,
        val icon: String
    )

    data class Forecast(
        @SerializedName("forecastday")val forecastdays: List<ForecastDay>
    )

    data class ForecastDay(
        val date: String,
        val day: Day
    )

    data class Day(
        val maxtemp_c: Double,
        val mintemp_c: Double,
        val condition: Condition,
        val totalprecip_mm: Double,
        val daily_chance_of_rain: Int,
        val maxwind_kph: Double,
        val avghumidity: Int
    )

    data class Condition(
        val text: String,
        val icon: String
    )

//    data class Current(
//        @DrawableRes val imageRes: Int,
//        val condition: String,
//        val temperature: String,
//        val precipitationType: String,
//        val precipitationAmount: String,
//        val windDirection: String,
//        val windSpeed: String
//    )
//
//    data class Forecast(
//        val date: String,
//        @DrawableRes val imageRes: Int,
//        val high: String,
//        val low: String,
//        val condition: String,
//        val precipitationType: String,
//        val precipitationAmount: String,
//        val precipitationProbability: String,
//        val windDirection: String,
//        val windSpeed: String,
//        val humidity: String
//    )

}