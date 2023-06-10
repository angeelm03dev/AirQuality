package com.angel.airquality.model.airQualityOpenData

import com.google.gson.annotations.SerializedName

data class StatusAirQuality(
    @SerializedName("status") val status: String?,
    @SerializedName("data") val data: Data?
)
