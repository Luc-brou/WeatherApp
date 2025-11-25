package com.example.weatherapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Dark theme colors
private val DarkColorScheme = darkColorScheme(
    primary = BluePrimary,        // strong blue for top bar/buttons
    secondary = Secondary,    // lighter blue accents
    tertiary = BlueAccent,        // pastel blue highlights
    background = Color(0xFF121212), // dark background
    surface = Color(0xFF1E1E1E),    // dark surfaces
    onPrimary = Color.White,      // text/icons on blue
    onSecondary = Color.Black,    // text/icons on lighter blue
    onTertiary = Color.Black,
    onBackground = Color.White,   // text on dark background
    onSurface = Color.White       // text on dark surfaces
)

// Light theme colors
private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,        // strong blue for top bar/buttons
    secondary = Secondary,    // lighter blue accents
    tertiary = BlueAccent,        // pastel blue highlights
    background = WhiteBackground, // clean white background
    surface = LightGreySurface,   // subtle grey surfaces
    onPrimary = Color.White,      // text/icons on blue
    onSecondary = DarkText,       // text/icons on lighter blue
    onTertiary = DarkText,
    onBackground = DarkText,      // main text color
    onSurface = DarkText          // text on surfaces
)

@Composable
fun WeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}