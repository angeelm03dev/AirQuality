package com.angel.airquality

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import com.angel.airquality.database.AppDatabase
import com.angel.airquality.model.news.NewsResponse

object GlobalVars {
    lateinit var db: AppDatabase

    var pollutionNews = mutableStateListOf<NewsResponse>()
    var locationsMapList = mutableStateMapOf<String, Int>()
    var activeLocation = listOf<String>()
}