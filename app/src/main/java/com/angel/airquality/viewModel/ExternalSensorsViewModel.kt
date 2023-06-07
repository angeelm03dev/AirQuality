package com.angel.airquality.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.angel.airquality.MainActivity
import com.angel.airquality.api.APIService
import com.angel.airquality.model.airQualityOpenData.LocationStatusAirQuality
import com.angel.airquality.model.airQualityOpenData.StatusAirQuality
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExternalSensorsViewModel : ViewModel() {

    //Esto habría que sacarlo a una clase a parte
    private fun getRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.waqi.info")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    //Consultamos la calidad del aire en una determinada ciudad
    fun searchAirQualityLocations(
        context: MainActivity,
        locationStatusAirQualityList: MutableList<LocationStatusAirQuality>,
        locations: MutableList<String>
    ) {
        locationStatusAirQualityList.clear()
        try {
            CoroutineScope(Dispatchers.IO).launch {
                locations.forEach { location ->
                    //Procesamos todas las localizaciones
                    val call = getRetrofit().create(APIService::class.java)
                        .getAirQuality(location, "471cc665254f8d26ac2fa513f249e2b2868bf7ef")
                    val response = call.execute()
                    val statusAirQuality = response.body()

                    context.runOnUiThread {
                        if (statusAirQuality != null) {
                            locationStatusAirQualityList.add(LocationStatusAirQuality(location, statusAirQuality))
                        }
                    }
                }
            }

        } catch (ex: Exception) {
            Log.e(
                "Excepcion API",
                "Error al realizar la consulta a la API AirQuality Open Data.\n$ex"
            )
        }
    }

}