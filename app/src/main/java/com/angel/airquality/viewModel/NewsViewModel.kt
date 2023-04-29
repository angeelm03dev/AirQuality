package com.angel.airquality.viewModel

import android.util.Log
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.angel.airquality.MainActivity
import com.angel.airquality.R
import com.angel.airquality.api.APIService
import com.angel.airquality.model.NewsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsViewModel() : ViewModel() {

    val pollutionNews = mutableStateListOf<NewsResponse>()

    private fun getRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .build()

        return Retrofit.Builder()
            .baseUrl("http://api.mediastack.com/v1/news/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun searchPollutionNews(context: MainActivity) {
        try {
            CoroutineScope(Dispatchers.IO).launch {

                val call = getRetrofit().create(APIService::class.java).getNews(
                    access_key = context.getString(R.string.api_key),
                    keywords = "contaminación",
                    countries = "es"
                )
                val response = call.execute()
                val news = response.body()

                context.runOnUiThread{
                    if (response.isSuccessful) {
                        val dataNews = news?.data ?: emptyList()
                        pollutionNews.clear()
                        pollutionNews.addAll(dataNews)
                    }
                }
            }
        } catch (ex: Exception) {
            Log.e("Excepcion API", "Error al realizar la cconsulta a la API Mediastack.\n$ex")
        }
    }

}