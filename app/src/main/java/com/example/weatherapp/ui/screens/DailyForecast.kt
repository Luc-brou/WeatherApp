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
import com.example.weatherapp.R

@Composable
fun DailyForecast(
    date1: String,
    tempInfo1: String,
    conditionInfo1: String,
    precipitationInfo1: String,
    windInfo1: String,
    humidity1: String,

    date2: String,
    tempInfo2: String,
    conditionInfo2: String,
    precipitationInfo2: String,
    windInfo2: String,
    humidity2: String,

    date3: String,
    tempInfo3: String,
    conditionInfo3: String,
    precipitationInfo3: String,
    windInfo3: String,
    humidity3: String,

    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.sunny),
                contentDescription = "Sunny weather",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Date: $date1\n" +
                        "Temperature Info: $tempInfo1\n" +
                        "Condition: $conditionInfo1\n" +
                        "Precipitation Info: $precipitationInfo1\n" +
                        "Wind Info: $windInfo1\n" +
                        "Humidity: $humidity1\n"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.rainy),
                contentDescription = "Rainy weather",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Date: $date2\n" +
                        "Temperature Info: $tempInfo2\n" +
                        "Condition: $conditionInfo2\n" +
                        "Precipitation Info: $precipitationInfo2\n" +
                        "Wind Info: $windInfo2\n" +
                        "Humidity: $humidity2\n"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.thunder),
                contentDescription = "Thunder weather",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Date: $date3\n" +
                        "Temperature Info: $tempInfo3\n" +
                        "Condition: $conditionInfo3\n" +
                        "Precipitation Info: $precipitationInfo3\n" +
                        "Wind Info: $windInfo3\n" +
                        "Humidity: $humidity3\n"
            )
        }
    }
}