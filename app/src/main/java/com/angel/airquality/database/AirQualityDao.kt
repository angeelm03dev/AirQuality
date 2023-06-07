package com.angel.airquality.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AirQualityDao {
    @Query("SELECT location FROM existing_locations")
    fun getAll(): List<String>
}