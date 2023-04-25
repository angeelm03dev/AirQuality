package com.angel.airquality

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.angel.airquality.api.APIService
import com.angel.airquality.navigation.ScreensNavigation
import com.angel.airquality.ui.theme.AirQualityTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        search("es", this)

        setContent {
            AirQualityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    ScreensNavigation(navController = navController)
                }
            }
        }
    }

    private fun getRetrofit():Retrofit{

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

    private fun search(country: String, context: MainActivity){

        CoroutineScope(Dispatchers.IO).launch {
            try{
                //Recordar agregar la API KEY
                val call = getRetrofit().create(APIService::class.java).getNews(access_key = "", countries = country)

                val newsPollution = call.execute()

                if (newsPollution.isSuccessful){
                    val newPollution = newsPollution.body()
                    val data = newPollution?.data

                    if (newPollution != null) {
                        data?.forEach {
                            Log.d("RESULTADO", it.description)
                        }
                    }
                    //Toast.makeText(context, newPollution.toString(), Toast.LENGTH_SHORT).show()
                }

            }catch(ex: Exception){
                Log.e("Excepcion API","Error al realizar la cconsulta a la API Mediastack.\n$ex")
            }
        }

    }

}