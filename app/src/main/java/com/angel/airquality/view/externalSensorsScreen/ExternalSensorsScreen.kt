package com.angel.airquality.view.externalSensorsScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.view.externalSensorsScreen.components.CustomLinearProgressBar
import com.angel.airquality.view.externalSensorsScreen.components.ExternalSensorBox
import com.angel.airquality.view.externalSensorsScreen.components.RoundFloatingButton
import com.angel.airquality.view.externalSensorsScreen.components.editDialog.EditDialog
import com.angel.airquality.viewModel.ExternalSensorsViewModel

var firstStart = true

@Composable
fun ExternalSensorsScreen(
    context: MainActivity,
    externalSensorsViewModel: ExternalSensorsViewModel,
    innerPadding: PaddingValues
) {
    val openDialog = remember { mutableStateOf(false) }
    val loader = remember { mutableStateOf(false) }

    if (firstStart) {
        loader.value = true
        Toast.makeText(context, "Cargando", Toast.LENGTH_SHORT).show()
        LaunchedEffect(key1 = true){
            externalSensorsViewModel.searchAirQualityLocations(
                externalSensorsViewModel = externalSensorsViewModel,
                loader = loader,
                context = context
            )
        }
        firstStart = false
    }

    //Modificamos el contenido de la mutableList
    Column {
        if (loader.value){
            CustomLinearProgressBar()
        }
        Box(
            modifier = Modifier
                .background(color = Color(0xFFEAF8FF))
                .padding(innerPadding)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                GlobalVars.locationStatusAirQualitylist.forEach { locationStatusAirQuality ->
                    item {
                        locationStatusAirQuality.location?.let {
                            ExternalSensorBox(
                                dataAirQuality = locationStatusAirQuality.statusAirQualitya?.data,
                                location = it,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
            Row(modifier = Modifier.align(Alignment.BottomEnd)) {
                if (!loader.value){
                    RoundFloatingButton(
                        imageVector = Icons.Default.Refresh,
                        onClick = {
                            loader.value = true
                            externalSensorsViewModel.searchAirQualityLocations(
                                externalSensorsViewModel = externalSensorsViewModel,
                                loader = loader,
                                context = context
                            )
                        },
                        modifier = Modifier
                            .padding(bottom = 20.dp, start = 10.dp, end = 5.dp)
                    )
                    RoundFloatingButton(
                        imageVector = Icons.Default.Edit,
                        onClick = {
                            openDialog.value = !openDialog.value
                        },
                        modifier = Modifier
                            .padding(bottom = 20.dp, start = 5.dp, end = 10.dp)
                    )
                }
            }

        }
    }
    if (openDialog.value) {
        EditDialog(context, openDialog, externalSensorsViewModel)
    }
}
