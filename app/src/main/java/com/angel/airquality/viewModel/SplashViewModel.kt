package com.angel.airquality.viewModel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.room.Room
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.R
import com.angel.airquality.api.APIService
import com.angel.airquality.database.AppDatabase
import com.angel.airquality.navigation.AppScreens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SplashViewModel : ViewModel(){

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

    fun dataLoad(context: MainActivity, navController: NavController){
        CoroutineScope(Dispatchers.IO).launch {
            val db = Room.databaseBuilder(context, AppDatabase::class.java, "db_airquality.db")
                .createFromAsset("database/db_airquality.db")
                .fallbackToDestructiveMigration()
                .build()

            val locationDao = db.userDao()
            val locations = locationDao.getAll()

            locations.forEach{
                GlobalVars.locationsList += it
            }

            context.runOnUiThread {
                navController.popBackStack()
                navController.navigate(AppScreens.Home.ruta)
            }
        }
    }

    fun searchPollutionNews(context: MainActivity) {
        try {
            CoroutineScope(Dispatchers.IO).launch {

                val call = getRetrofit().create(APIService::class.java).getNews(
                    access_key = context.getString(R.string.api_news_key),
                    keywords = "contaminación",
                    countries = "es"
                )
                val response = call.execute()
                val news = response.body()

                context.runOnUiThread{
                    if (response.isSuccessful) {
                        val dataNews = news?.data ?: emptyList()
                        GlobalVars.pollutionNews.clear()
                        GlobalVars.pollutionNews.addAll(dataNews)
                    }
                }
            }
        } catch (ex: Exception) {
            Log.e("Excepcion API", "Error al realizar la cconsulta a la API Mediastack.\n$ex")
        }
    }
}