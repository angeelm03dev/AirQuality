package com.angel.airquality.view.externalSensorsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun ExternalSensorsScreen(
    context: MainActivity,
    externalSensorsViewModel: ExternalSensorsViewModel,
    innerPadding: PaddingValues
) {
    val openDialog = remember { mutableStateOf(false) }
    val locationStatusAirQualitylist = remember { mutableStateListOf(LocationStatusAirQuality(null, null)) }


    if (!openDialog.value){
        externalSensorsViewModel.searchAirQualityLocations(
            locations = GlobalVars.locationsList,
            locationStatusAirQualityList = locationStatusAirQualitylist,
            context = context
        )
    }


    //Modificamos el contenido de la mutableList

    if(!openDialog.value) {
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                locationStatusAirQualitylist.forEach { locationStatusAirQuality ->
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
            RoundFloatingButton(
                imageVector = Icons.Default.Edit,
                onClick = {
                    openDialog.value = !openDialog.value
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(20.dp)
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
