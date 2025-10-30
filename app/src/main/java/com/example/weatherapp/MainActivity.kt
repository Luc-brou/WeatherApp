//package com.example.weatherapp
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.WindowInsets
//import androidx.compose.material3.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Info
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.navigation.compose.*
//import androidx.navigation.compose.rememberNavController
////import com.example.weatherapp.ui.screens.CurrentWeather
////import com.example.weatherapp.ui.screens.DailyForecast
//import com.example.weatherapp.ui.theme.WeatherAppTheme
//
//class MainActivity : ComponentActivity() {
//
//    private val mainViewModel = MainViewModel()
//
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        setContent {
//            val weatherState by mainViewModel.weather.collectAsState()
//
////            LaunchedEffect(Unit) {
////                mainViewModel.fetchWeather("453d2381a82d4521ac5174748251510", "Halifax", 3) //update to match location lecture
////            }
//
//            WeatherAppTheme {
//                val navController = rememberNavController()
//
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    topBar = { TopBarContent() },
//                    bottomBar = {
//                        NavigationBar {
//                            NavigationBarItem(
//                                selected = navController.currentDestination?.route == "current",
//                                onClick = { navController.navigate("current") },
//                                icon = { Icon(Icons.Default.Home, contentDescription = "Current Weather") },
//                                label = { Text("Current Weather") }
//                            )
//                            NavigationBarItem(
//                                selected = navController.currentDestination?.route == "forecast",
//                                onClick = { navController.navigate("forecast") },
//                                icon = { Icon(Icons.Default.Info, contentDescription = "Daily Forecast") },
//                                label = { Text("Daily Forecast") }
//                            )
//                        }
//                    }
//                ) { innerPadding ->
//                    NavHost(
//                        navController = navController,
//                        startDestination = "current",
//                        modifier = Modifier.padding(innerPadding)
//                    ) {
////                        composable("current") {
////                            weatherState?.let { CurrentWeather(current = it.current) }
////                        }
////                        composable("forecast") {
////                            weatherState?.let { DailyForecast(forecasts = it.forecast.forecastDays) }
////                        }
//                    }
//                }
//            }
//        }
//    }
//
//    @OptIn(ExperimentalMaterial3Api::class)
//    @Composable
//    fun TopBarContent() {
//        TopAppBar(
//            colors = TopAppBarDefaults.topAppBarColors(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                titleContentColor = MaterialTheme.colorScheme.primary,
//            ),
//            title = {
//                Text("Halifax, Nova Scotia") //hard coded location variable
//            }
//        )
//    }
//
//    @OptIn(InternalComposeApi::class)
//    @Composable
//    @ComposableInferredTarget("")
//    public fun CustomScaffold(
//        modifier: Modifier = Modifier,
//        topBar: @Composable (() -> Unit) = { TopBarContent() },
//        bottomBar: @Composable (() -> Unit) = {},
//        snackbarHost: @Composable (() -> Unit) = {},
//        floatingActionButton: @Composable (() -> Unit) = {},
//        floatingActionButtonPosition: FabPosition = FabPosition.End,
//        containerColor: Color = MaterialTheme.colorScheme.background,
//        contentColor: Color = contentColorFor(containerColor),
//        contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
//        content: @Composable (PaddingValues) -> Unit
//    ) {
//        // Implementation goes here
//    }
//}

package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Data model (simplified just to prove it works)
data class WeatherResponse(
    val location: Location,
    val current: Current
) {
    data class Location(val name: String, val country: String)
    data class Current(val temp_c: Double, val condition: Condition)
    data class Condition(val text: String, val icon: String)
}

// Retrofit service
interface WeatherApiService {
    @GET("v1/forecast.json")
    suspend fun getForecast(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): WeatherResponse
}

// ViewModel
class MainViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(WeatherApiService::class.java)

    var weatherText by mutableStateOf("Loading...")
        private set

    fun fetchWeather() {
        viewModelScope.launch {
            try {
                val response = api.getForecast(
                    "453d2381a82d4521ac5174748251510", // put your key here
                    "Halifax",
                    1
                )
                weatherText = "Location: ${response.location.name}, ${response.location.country}\n" +
                        "Temp: ${response.current.temp_c}°C\n" +
                        "Condition: ${response.current.condition.text}"
            } catch (e: Exception) {
                weatherText = "Error: ${e.message}"
            }
        }
    }
}

// Activity
class MainActivity : ComponentActivity() {
    private val vm = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.fetchWeather()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Text(vm.weatherText)
            }
        }
    }
}