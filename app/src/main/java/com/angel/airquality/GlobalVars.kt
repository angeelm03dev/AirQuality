package com.angel.airquality

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.angel.airquality.model.airQualityOpenData.LocationStatusAirQuality
import com.angel.airquality.model.news.NewsResponse

object GlobalVars {
    var pollutionNews = mutableStateListOf<NewsResponse>()

    var locationsList = mutableStateListOf<String>()
    var existingLocationsList = mutableStateListOf<String>()
}