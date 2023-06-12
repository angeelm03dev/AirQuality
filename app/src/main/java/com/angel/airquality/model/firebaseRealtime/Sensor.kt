package com.angel.airquality.model.firebaseRealtime

import com.google.gson.annotations.SerializedName

data class Sensor(
    @SerializedName("data") val data: String,
    @SerializedName("name") val name: String,
    @SerializedName("time") val time: String,
    @SerializedName("value") val value: Int
)
