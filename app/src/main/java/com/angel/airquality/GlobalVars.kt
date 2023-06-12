package com.angel.airquality

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import com.angel.airquality.database.AppDatabase
import com.angel.airquality.model.airQualityOpenData.LocationStatusAirQuality
import com.angel.airquality.model.news.NewsResponse
import com.angel.airquality.view.homeScreen.Screen

object GlobalVars {
    lateinit var db: AppDatabase
    val screen: Screen = Screen.LocalSensors

    var pollutionNews = mutableStateListOf<NewsResponse>()
    var locationStatusAirQualitylist = mutableStateListOf<LocationStatusAirQuality>()
    var locationsMapList = mutableStateMapOf<String, Int>()
    var currentScreen = mutableStateOf(screen)
    var activeLocation = listOf<String>()
}