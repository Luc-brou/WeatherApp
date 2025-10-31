package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.models.Weather
import coil.compose.AsyncImage //for images

@Composable
fun CurrentWeather(current: Weather.Current, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // The API icons start with "//", so this prepends "https:"
        val iconUrl = if (current.condition.icon.startsWith("//")) {
            "https:${current.condition.icon}"
        } else {
            current.condition.icon
        }

        AsyncImage(
            model = iconUrl,
            contentDescription = current.condition.text,
            modifier = Modifier.size(64.dp)
        )

        Text( //here is the text that displays on the app. based on JSON data.
            text = "Condition: ${current.condition.text}\n" +
                    "Temperature: ${current.currentTemp}°C\n" +
                    "Precipitation: ${current.currentPrecipitation} mm\n" +
                    "Wind: ${current.windDirection}, ${current.wind} kph\n" +
                    "Humidity: ${current.humidity}%"
        )
    }
}