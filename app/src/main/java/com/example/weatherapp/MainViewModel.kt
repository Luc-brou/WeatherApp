package com.example.weatherapp

import androidx.lifecycle.ViewModel

data class Weather(
    val condition: String,
    val temperature: String,
    val precipitation: String,
    val wind: String
)

data class Forecast(
    val date: String,
    val temperature: String,
    val condition: String,
    val precipitation: String,
    val wind: String,
    val humidity: String
)

class MainViewModel : ViewModel() {

    val currentWeather: Weather

    init {
        currentWeather = Weather(
            condition = "Sunny",
            temperature = "22°C",
            precipitation = "None",
            wind = "North, 22 km/h"
        )
    }


    val dailyForecast1: Forecast

    init {
        dailyForecast1 = Forecast(
            date = "October 5th, 2025",
            temperature = "15 degrees celcius",
            condition = "Sunny",
            precipitation = "Rain, 20mm, 50% probability",
            wind = "20km/h North",
            humidity = "50% humidity"
        )
    }

    val dailyForecast2: Forecast

    init {
        dailyForecast2 = Forecast(
            date = "October 6th, 2025",
            temperature = "10 degrees celcius",
            condition = "Rainy",
            precipitation = "Rain, 20mm, 90% probability",
            wind = "20km/h North",
            humidity = "60% humidity"
        )
    }

    val dailyForecast3: Forecast

    init {
        dailyForecast3 = Forecast(
            date = "October 7th, 2025",
            temperature = "10 degrees celcius",
            condition = "Thunder",
            precipitation = "Rain, 20mm, 70% probability of thunder",
            wind = "20km/h North",
            humidity = "70% humidity"
        )
    }

}