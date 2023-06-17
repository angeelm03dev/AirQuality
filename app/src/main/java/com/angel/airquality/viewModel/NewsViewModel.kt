package com.angel.airquality.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.R
import com.angel.airquality.api.APIService
import com.angel.airquality.model.news.NewsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsViewModel() : ViewModel() {

}