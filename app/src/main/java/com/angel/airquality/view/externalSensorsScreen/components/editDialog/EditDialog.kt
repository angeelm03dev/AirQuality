package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.angel.airquality.GlobalVars
import com.angel.airquality.viewModel.ExternalSensorsViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EditDialog(
    openDialog: MutableState<Boolean>,
    externalSensorsViewModel: ExternalSensorsViewModel
) {
    val locations = remember { mutableStateListOf("") }

    //Cargamos las localizaciones
    locations.clear()
    GlobalVars.locationsMapList.forEach {
        locations.add(it.key)
    }

    if (openDialog.value) {
        Dialog(
            onDismissRequest = {
                openDialog.value = false
            },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Card(
                elevation = 5.dp,
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    ListLocations(
                        locations = locations,
                        externalSensorsViewModel = externalSensorsViewModel
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    RowButton(openDialog = openDialog)
                }
            }
        }
    }
}
