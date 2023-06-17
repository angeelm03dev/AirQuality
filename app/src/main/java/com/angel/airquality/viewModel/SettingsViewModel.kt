package com.angel.airquality.viewModel

import androidx.lifecycle.ViewModel
import com.angel.airquality.GlobalVars
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel(){
    fun resetLocatins(){
        CoroutineScope(Dispatchers.IO).launch {
            GlobalVars.locationStatusAirQualitylist.clear()
            val locationDao = GlobalVars.db.userDao()
            //Desactivamos todas las localizaciones
            locationDao.resetLocations()

            //Actualizamos el map de localizaciones guardado en la memoria
            val locationsMap = locationDao.getLocationsWithIsActive()
            GlobalVars.locationsMapList.clear()
            locationsMap.forEach{
                GlobalVars.locationsMapList[it.location] = it.isActive
            }
        }
    }
}