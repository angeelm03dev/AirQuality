package com.angel.airquality.model.news

import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("pagination") val pagination: Pagination,
    @SerializedName("data") val data: List<NewsResponse>
)
