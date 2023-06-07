package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.viewModel.EditDialogViewModel
import com.angel.airquality.viewModel.ExternalSensorsViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EditDialog(
    context: MainActivity,
    openDialog: MutableState<Boolean>,
    externalSensorsViewModel: ExternalSensorsViewModel
) {
    val locations = remember { GlobalVars.locationsList }

    if (openDialog.value) {
        Dialog(
            onDismissRequest = {
                openDialog.value = false
            },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ){
            Card(
                elevation = 5.dp,
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .border(1.dp, color = Color.Cyan, shape = RoundedCornerShape(15.dp)),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    verticalArrangement = Arrangement.Center
                ){
                    ListSavedLocations(locations)
                    RowButton(context = context, openDialog = openDialog, externalSensorsViewModel)
                }
            }
        }
    }
}
