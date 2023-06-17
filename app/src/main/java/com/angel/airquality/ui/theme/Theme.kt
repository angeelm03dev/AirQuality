package com.angel.airquality.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = OffBlue,
    primaryVariant = LightBlue,
    secondary = LightBeige,
    secondaryVariant = LightGrey
)

private val DarkColorPalette = darkColors(
    primary = Dark,
    primaryVariant = DarkBlue,
    secondary = DarkBeige,
    secondaryVariant = DarkGrey
)

@Composable
fun AirQualityTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}