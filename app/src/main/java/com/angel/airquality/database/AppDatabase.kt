package com.angel.airquality.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.angel.airquality.model.sqlite.Locations

@Database(entities = [Locations::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): AirQualityDao
}