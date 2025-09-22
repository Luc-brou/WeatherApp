package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    currentWeatherScreen(
                        weather = mainViewModel.currentWeatherCondition,
                        temperature = mainViewModel.currentWeatherTemperature,
                        precipitation = mainViewModel.currentWeatherPrecipitation,
                        wind = mainViewModel.currentWeatherWind,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun currentWeatherScreen(
    weather: String,
    temperature: String,
    precipitation: String,
    wind: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Condition: $weather\nTemperature: $temperature\nPrecipitation: $precipitation\nWind: $wind",
        modifier = modifier
    )
}