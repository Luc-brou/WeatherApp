package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.screens.CurrentWeather
import com.example.weatherapp.ui.screens.DailyForecast
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel = MainViewModel()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            WeatherAppTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBarContent() },
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = navController.currentDestination?.route == "current",
                                onClick = { navController.navigate("current") },
                                icon = { Icon(Icons.Default.Home, contentDescription = "Current Weather") },
                                label = { Text("Current Weather") }
                            )
                            NavigationBarItem(
                                selected = navController.currentDestination?.route == "forecast",
                                onClick = { navController.navigate("forecast") },
                                icon = { Icon(Icons.Default.Info, contentDescription = "Daily Forecast") },
                                label = { Text("Daily Forecast") }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "current",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("current") {
                            CurrentWeather(
                                condition = mainViewModel.currentWeather.condition,
                                temperature = mainViewModel.currentWeather.temperature,
                                precipitation = mainViewModel.currentWeather.precipitation,
                                wind = mainViewModel.currentWeather.wind
                            )
                        }
                        composable("forecast") {
                            DailyForecast(
                                date1 = mainViewModel.dailyForecast1.date,
                                tempInfo1 = mainViewModel.dailyForecast1.temperature,
                                conditionInfo1 = mainViewModel.dailyForecast1.condition,
                                precipitationInfo1 = mainViewModel.dailyForecast1.precipitation,
                                windInfo1 = mainViewModel.dailyForecast1.wind,
                                humidity1 = mainViewModel.dailyForecast1.humidity,

                                date2 = mainViewModel.dailyForecast2.date,
                                tempInfo2 = mainViewModel.dailyForecast2.temperature,
                                conditionInfo2 = mainViewModel.dailyForecast2.condition,
                                precipitationInfo2 = mainViewModel.dailyForecast2.precipitation,
                                windInfo2 = mainViewModel.dailyForecast2.wind,
                                humidity2 = mainViewModel.dailyForecast2.humidity,

                                date3 = mainViewModel.dailyForecast3.date,
                                tempInfo3 = mainViewModel.dailyForecast3.temperature,
                                conditionInfo3 = mainViewModel.dailyForecast3.condition,
                                precipitationInfo3 = mainViewModel.dailyForecast3.precipitation,
                                windInfo3 = mainViewModel.dailyForecast3.wind,
                                humidity3 = mainViewModel.dailyForecast3.humidity
                            )
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBarContent() {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text("Halifax, Nova Scotia") //hard coded location variable
            }
        )
    }

    @OptIn(InternalComposeApi::class)
    @Composable
    @ComposableInferredTarget("")
    public fun CustomScaffold(
        modifier: Modifier = Modifier,
        topBar: @Composable (() -> Unit) = { TopBarContent() },
        bottomBar: @Composable (() -> Unit) = {},
        snackbarHost: @Composable (() -> Unit) = {},
        floatingActionButton: @Composable (() -> Unit) = {},
        floatingActionButtonPosition: FabPosition = FabPosition.End,
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = contentColorFor(containerColor),
        contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
        content: @Composable (PaddingValues) -> Unit
    ) {
        // Implementation goes here
    }
}