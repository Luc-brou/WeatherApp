package com.example.weatherapp.models

import androidx.annotation.DrawableRes

data class Weather(
    val current: Current,
    val forecast: List<Forecast>
) {
    data class Current(
        @DrawableRes val imageRes: Int,
        val condition: String,
        val temperature: String,
        val precipitationType: String,
        val precipitationAmount: String,
        val windDirection: String,
        val windSpeed: String
    )

    data class Forecast(
        val date: String,
        @DrawableRes val imageRes: Int,
        val high: String,
        val low: String,
        val condition: String,
        val precipitationType: String,
        val precipitationAmount: String,
        val precipitationProbability: String,
        val windDirection: String,
        val windSpeed: String,
        val humidity: String
    )
}