package com.angel.airquality.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AirQualityDao {
    @Query("SELECT locations.location, locations.isActive FROM locations")
    fun getLocationsWithIsActive(): List<LocationData>

    @Query("SELECT locations.location FROM locations WHERE locations.isActive = 1")
    fun activeLocations(): List<String>

    @Query("UPDATE locations SET isActive = :isActive WHERE location = :location")
    fun updateLocation(location: String, isActive: Int)

    @Query("UPDATE locations SET isActive = 0")
    fun resetLocations()
}

data class LocationData(
    val location: String,
    val isActive: Int
)