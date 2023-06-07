package com.angel.airquality.model.sqlite

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Existing_locations(
    @PrimaryKey val location: String,
)
