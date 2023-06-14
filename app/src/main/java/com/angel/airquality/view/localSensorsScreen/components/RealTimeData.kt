package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.angel.airquality.MainActivity
import com.angel.airquality.model.firebaseRealtime.Sensor
import com.angel.airquality.viewModel.LocalSensorsViewModel

@Composable
fun RealTimeData(
    context: MainActivity,
    localSensorsViewModel: LocalSensorsViewModel,
    modifier: Modifier,
    sensor: MutableState<Sensor>
){
    Column(modifier = modifier) {
        Row {
            DataViewer(context = context, sensor = sensor, localSensorsViewModel = localSensorsViewModel)
            DataExplanation(sensor = sensor, localSensorsViewModel = localSensorsViewModel)
        }
    }
}