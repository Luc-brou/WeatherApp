package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.models.Weather

@Composable
fun DailyForecast(forecasts: List<Weather.Forecast>, modifier: Modifier = Modifier) {
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
                Image(
                    painter = painterResource(id = forecast.imageRes),
                    contentDescription = forecast.condition,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Date: ${forecast.date}\n" +
                            "High: ${forecast.high}, Low: ${forecast.low}\n" +
                            "Condition: ${forecast.condition}\n" +
                            "Precipitation: ${forecast.precipitationType}, ${forecast.precipitationAmount}, ${forecast.precipitationProbability}\n" +
                            "Wind: ${forecast.windDirection}, ${forecast.windSpeed}\n" +
                            "Humidity: ${forecast.humidity}\n"
                )
            }
        }
    }
}