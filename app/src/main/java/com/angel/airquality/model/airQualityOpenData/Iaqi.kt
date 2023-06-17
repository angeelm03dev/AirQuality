package com.angel.airquality.model.airQualityOpenData

import com.google.gson.annotations.SerializedName

data class Iaqi(
    @SerializedName("no3") val no3: Value,
    @SerializedName("o3") val o3: Value,
    @SerializedName("pm10") val pm10: Value,
    @SerializedName("pm25") val pm25: Value,
    @SerializedName("so2") val so2: Value
)
