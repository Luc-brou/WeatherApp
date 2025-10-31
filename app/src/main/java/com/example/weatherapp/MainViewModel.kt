package com.example.weatherapp

import androidx.annotation.OptIn
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.example.weatherapp.models.Weather
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainViewModel : ViewModel() {

    private val _weather = MutableStateFlow<Weather?>(null)
    val weather: StateFlow<Weather?> = _weather.asStateFlow()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/") //extra URL info is appended from MainActivity
        .addConverterFactory(GsonConverterFactory.create())
        .build() //once appended it gets the full URL to fetch data from.

    interface WeatherApiService {
        @GET("v1/forecast.json")
        suspend fun getForecast( //fetch data parameters
            @Query("key") apiKey: String,
            @Query("q") location: String,
            @Query("days") days: Int,
            @Query("aqi") aqi: String = "no",
            @Query("alerts") alerts: String = "no"
        ): Weather
    }

    private val api: WeatherApiService = retrofit.create(WeatherApiService::class.java) //retrofit service creation

    @OptIn(UnstableApi::class)
    fun fetchWeather(apiKey: String, location: String, days: Int = 3) {
        viewModelScope.launch {
            try {
                val response = api.getForecast(apiKey, location, days)
                _weather.value = response
            } catch (e: Exception) { //outputs in logcat
                Log.e("Weather", "Error fetching weather", e) //error catching if data doesnt load
            }
        }
    }
}