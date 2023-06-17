package com.angel.airquality.view.homeScreen

import com.angel.airquality.R

sealed class Screen(val title: Int) {
    object LocalSensors : Screen(R.string.local_screen_title)
    object ExternalSensors : Screen(R.string.external_screen_title)
    object NewsSensors : Screen(R.string.news_screen_title)
}