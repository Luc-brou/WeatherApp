package com.example.weatherapp

import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.Weather
import com.example.weatherapp.R
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainViewModel : ViewModel() {

    private val _weather = MutableStateFlow<Weather?>(null) //changed to be only changeable from
                                                                    //inside this view model class
    // Public immutable flow
    val weather: StateFlow<Weather> = _weather.asStateFlow()



    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}