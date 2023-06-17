package com.angel.airquality.model.sqlite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Locations(
    @PrimaryKey
    @ColumnInfo(name = "location")
    val location: String,

    @ColumnInfo(name = "isActive")
    val isActive: Int
)
