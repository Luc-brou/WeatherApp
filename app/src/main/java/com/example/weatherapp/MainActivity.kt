package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.weatherapp.ui.screens.CurrentWeather
import com.example.weatherapp.ui.screens.DailyForecast
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel = MainViewModel()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    //screen 1

//                    CurrentWeather(
//                        condition = mainViewModel.currentWeather.condition,
//                        temperature = mainViewModel.currentWeather.temperature,
//                        precipitation = mainViewModel.currentWeather.precipitation,
//                        wind = mainViewModel.currentWeather.wind
//                    )

                    //screen 2

                    DailyForecast(
                        date1 = mainViewModel.dailyForecast1.date,
                        tempInfo1 = mainViewModel.dailyForecast1.temperature,
                        conditionInfo1 = mainViewModel.dailyForecast1.condition,
                        precipitationInfo1 = mainViewModel.dailyForecast1.precipitation,
                        windInfo1 = mainViewModel.dailyForecast1.wind,
                        humidity1 = mainViewModel.dailyForecast1.humidity,

                        date2 = mainViewModel.dailyForecast2.date,
                        tempInfo2 = mainViewModel.dailyForecast2.temperature,
                        conditionInfo2 = mainViewModel.dailyForecast2.condition,
                        precipitationInfo2 = mainViewModel.dailyForecast2.precipitation,
                        windInfo2 = mainViewModel.dailyForecast2.wind,
                        humidity2 = mainViewModel.dailyForecast2.humidity,

                        date3 = mainViewModel.dailyForecast3.date,
                        tempInfo3 = mainViewModel.dailyForecast3.temperature,
                        conditionInfo3 = mainViewModel.dailyForecast3.condition,
                        precipitationInfo3 = mainViewModel.dailyForecast3.precipitation,
                        windInfo3 = mainViewModel.dailyForecast3.wind,
                        humidity3 = mainViewModel.dailyForecast3.humidity
                    )

                }
            }
        }
    }
}