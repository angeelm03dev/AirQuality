package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.angel.airquality.GlobalVars
import com.angel.airquality.viewModel.ExternalSensorsViewModel

@Composable
fun ItemLocation(location: String, externalSensorsViewModel: ExternalSensorsViewModel){
    val locations = remember { mutableStateListOf("") }

    //Cargamos las localizaciones
    locations.clear()
    GlobalVars.locationsMapList.forEach{
        locations.add(it.key)
    }

    val isActive: Boolean
    val isActiveInt = GlobalVars.locationsMapList[location]
    isActive = isActiveInt == 1
    val checkedState = remember { mutableStateOf(isActive) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(text = location, modifier = Modifier.padding(top = 13.dp))
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { isChecked ->
                checkedState.value = isChecked

                if (checkedState.value){
                    externalSensorsViewModel.updateIsActive(location = location, isActive = 1)
                }else{
                    externalSensorsViewModel.updateIsActive(location = location, isActive = 0)
                }
            },
            modifier = Modifier
        )
    }
}