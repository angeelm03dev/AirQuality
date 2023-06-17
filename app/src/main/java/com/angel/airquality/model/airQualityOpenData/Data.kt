package com.angel.airquality.model.airQualityOpenData

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("aqi") val aqi: Float,
    @SerializedName("idx") val idx: Float,
    @SerializedName("dominentpol") val dominentpol: String?,
    @SerializedName("iaqi") val iaqi: Iaqi?
)
