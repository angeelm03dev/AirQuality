package com.angel.airquality

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import com.angel.airquality.database.AppDatabase
import com.angel.airquality.model.airQualityOpenData.LocationStatusAirQuality
import com.angel.airquality.model.firebaseRealtime.Sensor
import com.angel.airquality.model.news.NewsResponse
import com.angel.airquality.view.homeScreen.Screen
import me.bytebeats.views.charts.line.LineChartData

object GlobalVars {
    lateinit var db: AppDatabase
    val screen: Screen = Screen.LocalSensors
    var currentScreen = mutableStateOf(screen)

    //News
    var pollutionNews = mutableStateListOf<NewsResponse>()

    //External Sensor
    var locationStatusAirQualitylist = mutableStateListOf<LocationStatusAirQuality>()
    var locationsMapList = mutableStateMapOf<String, Int>()
    val locations = mutableStateListOf<String>()

    //Local Sensor
    val sensor = mutableStateOf(Sensor("", "", "", 1400))
    val mutableListPoint = mutableStateListOf(
        LineChartData.Point(0F, ""),
        LineChartData.Point(0F, "")
    )
    val points = mutableStateOf(
        LineChartData(mutableListPoint, 20F, false)
    )
}