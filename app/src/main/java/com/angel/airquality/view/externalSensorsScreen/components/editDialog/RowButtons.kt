package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.viewModel.ExternalSensorsViewModel

@Composable
fun RowButton(
    context: MainActivity,
    openDialog: MutableState<Boolean>,
    externalSensorsViewModel: ExternalSensorsViewModel
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {
                openDialog.value = false
                //externalSensorsViewModel.searchAirQualityLocations(context = context, locations = GlobalVars.locationsList)
            }
        ) {
            Text("Volver")
        }
    }
}