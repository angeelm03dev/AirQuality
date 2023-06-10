package com.angel.airquality.model.airQualityOpenData

data class LocationStatusAirQuality(
    val location: String?,
    val isActive: Int,
    val statusAirQualitya: StatusAirQuality?
)
