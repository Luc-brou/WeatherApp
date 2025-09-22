package com.example.weatherapp
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

//    Add image placeholder image here
    var currentWeatherCondition : String
    var currentWeatherTemperature : String
    var currentWeatherPrecipitation : String
    var currentWeatherWind : String




    init {

        currentWeatherCondition = "Sunny."
        currentWeatherTemperature = "22 degrees"
        currentWeatherPrecipitation = "None"
        currentWeatherWind = "North, 22 km/h"

    }

}

//Current Weather:
//
//weather image
//
//condition
//
//temperature
//
//precipitation type and amount
//
//wind direction and speed