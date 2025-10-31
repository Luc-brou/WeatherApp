package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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

                // The API icons start with "//", so this prepends "https:"
                val iconUrl = if (forecast.day.condition.icon.startsWith("//")) {
                    "https:${forecast.day.condition.icon}"
                } else {
                    forecast.day.condition.icon
                }

                AsyncImage(
                    model = iconUrl,
                    contentDescription = forecast.day.condition.text,
                    modifier = Modifier.size(64.dp)
                )

                Text( //more detailed version of current weather screen, but for 3 days.
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