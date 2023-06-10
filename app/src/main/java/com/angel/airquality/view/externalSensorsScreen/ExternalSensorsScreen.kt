package com.angel.airquality.view.externalSensorsScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.model.airQualityOpenData.LocationStatusAirQuality
import com.angel.airquality.view.externalSensorsScreen.components.ExternalSensorBox
import com.angel.airquality.view.externalSensorsScreen.components.editDialog.EditDialog
import com.angel.airquality.viewModel.ExternalSensorsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

var firstStart = true

@Composable
fun ExternalSensorsScreen(
    context: MainActivity,
    locationStatusAirQualitylist: SnapshotStateList<LocationStatusAirQuality>,
    externalSensorsViewModel: ExternalSensorsViewModel,
    innerPadding: PaddingValues
) {
    val openDialog = remember { mutableStateOf(false) }

    if (firstStart) {
        Toast.makeText(context, "Cargando", Toast.LENGTH_SHORT).show()
        externalSensorsViewModel.searchAirQualityLocations(
            locationStatusAirQualityList = locationStatusAirQualitylist,
            externalSensorsViewModel = externalSensorsViewModel,
            context = context
        )
        firstStart = false
    }

    //Modificamos el contenido de la mutableList
    Box(
        modifier = Modifier.padding(innerPadding)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            locationStatusAirQualitylist.forEach { locationStatusAirQuality ->
                if (locationStatusAirQuality.isActive == 1) {
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
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
        Row(modifier = Modifier.align(Alignment.BottomEnd)) {
            RoundFloatingButton(
                imageVector = Icons.Default.Refresh,
                onClick = {
                    if (locationStatusAirQualitylist.size == GlobalVars.activeLocation.size) {
                        externalSensorsViewModel.searchAirQualityLocations(
                            locationStatusAirQualityList = locationStatusAirQualitylist,
                            externalSensorsViewModel = externalSensorsViewModel,
                            context = context
                        )
                    } else {
                        Toast.makeText(
                            context,
                            "Los datos se están actualizando",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .padding(bottom = 20.dp, start = 10.dp, end = 5.dp)
            )
            RoundFloatingButton(
                imageVector = Icons.Default.Edit,
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        GlobalVars.activeLocation = GlobalVars.db.userDao().activeLocations()
                    }
                    if (locationStatusAirQualitylist.size == GlobalVars.activeLocation.size) {
                        openDialog.value = !openDialog.value
                    } else {
                        Toast.makeText(
                            context,
                            "Cargando localizaciones. Espere un momento antes de poder editar",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .padding(bottom = 20.dp, start = 5.dp, end = 10.dp)
            )
        }

    }
    if (openDialog.value) {
        EditDialog(context, openDialog, externalSensorsViewModel)
    }
}

@Composable
fun RoundFloatingButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
    }
}
