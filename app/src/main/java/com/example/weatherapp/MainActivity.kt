package com.example.weatherapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.compose.*
import com.example.weatherapp.ui.screens.CurrentWeather
import com.example.weatherapp.ui.screens.DailyForecast
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource

class MainActivity : ComponentActivity() {

    private val mainViewModel = MainViewModel()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val weatherState by mainViewModel.weather.collectAsState()

            WeatherAppTheme {
                // Fetch Halifax weather immediately
                mainViewModel.fetchWeather("c585d97973f5434abfb03413253010", "Halifax", 3)
                //Display location perms popup
                GetLocation()

                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBarContent() },
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = currentRoute == "current",
                                onClick = {
                                    navController.navigate("current") {
                                        launchSingleTop = true
                                        popUpTo(navController.graph.startDestinationId)
                                    }
                                },
                                icon = { Icon(Icons.Default.Home, contentDescription = "Current Weather") },
                                label = { Text("Current Weather") }
                            )
                            NavigationBarItem(
                                selected = currentRoute == "forecast",
                                onClick = {
                                    navController.navigate("forecast") {
                                        launchSingleTop = true
                                        popUpTo(navController.graph.startDestinationId)
                                    }
                                },
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
                            weatherState?.let { CurrentWeather(current = it.current) }
                                ?: Text("Loading weather…")
                        }
                        composable("forecast") {
                            weatherState?.let { DailyForecast(forecasts = it.forecast.forecastDays) }
                                ?: Text("Loading forecast…")
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
                Text("WeatherApp")
            }
        )
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun GetLocation() {
        // Remember the permission state(asking for Fine location)
        val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

        if (permissionState.status.isGranted) {
            Log.i("TESTING", "Hurray, permission granted!")

            // Get Location
            val currentContext = LocalContext.current
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(currentContext)

            if (ContextCompat.checkSelfPermission(
                    currentContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED)
            {
                val cancellationTokenSource = CancellationTokenSource()

                Log.i("TESTING", "Requesting location...")

                fusedLocationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, cancellationTokenSource.token)
                    .addOnSuccessListener { location ->
                        if (location != null) {
                            val lat = location.latitude.toString()
                            val lng = location.longitude.toString()

                            Log.i("TESTING", "Success: $lat $lng")

                            val coordinates = "$lat,$lng"

                            // call a function, like in View Model, to do something with location...
                        }
                        else {
                            Log.i("TESTING", "Problem encountered: Location returned null")
                        }
                    }
            }
        }
        else {
            // Run a side-effect (coroutine) to get permission. The permission popup.
            LaunchedEffect(permissionState){
                permissionState.launchPermissionRequest()
            }
        }
    }
}