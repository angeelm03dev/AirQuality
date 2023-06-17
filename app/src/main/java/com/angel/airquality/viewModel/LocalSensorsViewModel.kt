package com.angel.airquality.viewModel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.angel.airquality.MainActivity
import com.angel.airquality.api.APIService
import com.angel.airquality.model.firebaseRealtime.Sensor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocalSensorsViewModel: ViewModel() {
    private fun getRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://airquality-d62ba-default-rtdb.europe-west1.firebasedatabase.app")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun getSensor(context: MainActivity, sensor: MutableState<Sensor>) {
        CoroutineScope(Dispatchers.IO).launch {
            //Procesamos todas las localizaciones
            val call = getRetrofit().create(APIService::class.java).getSensor()
            val response = call.execute()
            val sensorData = response.body()

            context.runOnUiThread {
                if (sensorData != null) {
                    sensor.value = sensorData
                }
            }
        }
    }
}