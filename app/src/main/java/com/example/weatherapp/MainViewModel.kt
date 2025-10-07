package com.example.weatherapp

import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.Weather
import com.example.weatherapp.R

class MainViewModel : ViewModel() {

    val weather: Weather = Weather(
        current = Weather.Current(
            imageRes = R.drawable.sunny,
            condition = "Sunny",
            temperature = "22°C",
            precipitationType = "None",
            precipitationAmount = "0mm",
            windDirection = "North",
            windSpeed = "22 km/h"
        ),
        forecast = listOf(
            Weather.Forecast(
                date = "October 5th, 2025",
                imageRes = R.drawable.sunny,
                high = "15°C",
                low = "8°C",
                condition = "Sunny",
                precipitationType = "Rain",
                precipitationAmount = "20mm",
                precipitationProbability = "50%",
                windDirection = "North",
                windSpeed = "20 km/h",
                humidity = "50%"
            ),
            Weather.Forecast(
                date = "October 6th, 2025",
                imageRes = R.drawable.rainy,
                high = "10°C",
                low = "5°C",
                condition = "Rainy",
                precipitationType = "Rain",
                precipitationAmount = "20mm",
                precipitationProbability = "90%",
                windDirection = "North",
                windSpeed = "20 km/h",
                humidity = "60%"
            ),
            Weather.Forecast(
                date = "October 7th, 2025",
                imageRes = R.drawable.thunder,
                high = "10°C",
                low = "4°C",
                condition = "Thunder",
                precipitationType = "Rain",
                precipitationAmount = "20mm",
                precipitationProbability = "70%",
                windDirection = "North",
                windSpeed = "20 km/h",
                humidity = "70%"
            )
        )
    )
}