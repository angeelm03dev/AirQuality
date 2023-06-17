package com.angel.airquality.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.api.APIService
import com.angel.airquality.model.airQualityOpenData.LocationStatusAirQuality
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
        externalSensorsViewModel: ExternalSensorsViewModel,
        loader: MutableState<Boolean>
    ){
        //Obtenemos las localizaciones activadas
        val locationsMap = GlobalVars.locationsMapList

        GlobalVars.locationStatusAirQualitylist.clear()
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val locations = GlobalVars.db.userDao().activeLocations()

                locations.forEach { location ->
                    //Procesamos todas las localizaciones
                    val call = getRetrofit().create(APIService::class.java)
                        .getAirQuality(location, "471cc665254f8d26ac2fa513f249e2b2868bf7ef")
                    val response = call.execute()
                    val statusAirQuality = response.body()

                    context.runOnUiThread {
                        if (statusAirQuality != null) {
                            GlobalVars.locationStatusAirQualitylist.add(LocationStatusAirQuality(location,
                                locationsMap[location]!!, statusAirQuality))
                        }
                        externalSensorsViewModel.loadLocationMap()
                    }
                }
                loader.value = false
            }
        } catch (ex: Exception) {
            Log.e(
                "Excepcion API",
                "Error al realizar la consulta a la API AirQuality Open Data.\n$ex"
            )
        }
    }

    //Cargamos un Map<String, Int> con el nombre de la locaslización y un valor que indica si está activada o no
    private fun loadLocationMap(){
        CoroutineScope(Dispatchers.IO).launch {
            val locationDao = GlobalVars.db.userDao()
            val locationsMap = locationDao.getLocationsWithIsActive()

            GlobalVars.locationsMapList.clear()
            locationsMap.forEach{
                GlobalVars.locationsMapList[it.location] = it.isActive
            }
        }
    }

    fun updateIsActive(location: String, isActive: Int){
        CoroutineScope(Dispatchers.IO).launch {
            GlobalVars.locationsMapList[location] = isActive
            val locationDao = GlobalVars.db.userDao()
            locationDao.updateLocation(location = location, isActive = isActive)
        }
    }

}