//package com.example.weatherapp.ui.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import com.example.weatherapp.models.Weather
//
//@Composable
//fun CurrentWeather(current: Weather.Current, modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Top
//    ) {
////        Image(
////            painter = painterResource(id = current.imageRes),
////            contentDescription = current.condition,
////            contentScale = ContentScale.Crop,
////            modifier = Modifier
////                .fillMaxWidth()
////                .height(200.dp)
////        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "Condition: ${current.condition}\n" +
//                    "Temperature: ${current.temperature}\n" +
//                    "Precipitation: ${current.precipitationAmount}\n" + //removing type because nothing matching in json//
//                    "Wind: ${current.windDirection}, ${current.windSpeed}"
//        )
//    }
//}