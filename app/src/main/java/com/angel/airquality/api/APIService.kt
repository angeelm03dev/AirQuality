package com.angel.airquality.api

import com.angel.airquality.model.news.NewsData
import com.angel.airquality.model.airQualityOpenData.StatusAirQuality
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("/v1/news")
    fun getNews(
        @Query("access_key") access_key: String,
        @Query("countries") countries: String,
        @Query("keywords") keywords: String
    ): Call<NewsData>

    @GET("/feed/{city}")
    fun getAirQuality(
        @Path("city") city: String,
        @Query("token") token: String
    ): Call<StatusAirQuality>
}