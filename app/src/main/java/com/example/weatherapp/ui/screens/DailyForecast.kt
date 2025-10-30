package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.models.Weather

@Composable
fun DailyForecast(forecasts: List<Weather.ForecastDay>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        forecasts.forEach { forecast ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
            ) {
                Text(
                    text = "Date: ${forecast.date}\n" +
                            "High: ${forecast.day.maxTemp}°C, Low: ${forecast.day.minTemp}°C\n" +
                            "Condition: ${forecast.day.condition.text}\n" +
                            "Precipitation: ${forecast.day.totalPrecipMm} mm, Chance of rain: ${forecast.day.dailyChanceOfRain}%\n" +
                            "Wind: ${forecast.day.maxWind} kph\n" +
                            "Humidity: ${forecast.day.avgHumidity}%"
                )
            }
        }
    }
}