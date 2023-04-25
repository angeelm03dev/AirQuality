package com.angel.airquality.view.homeScreen

sealed class Screen(val title: String) {
    object LocalSensors : Screen("Local Sensors")
    object ExternalSensors : Screen("External Sensors")
    object NewsSensors : Screen("News")
}