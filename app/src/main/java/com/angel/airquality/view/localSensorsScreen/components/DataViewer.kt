package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.angel.airquality.MainActivity
import com.angel.airquality.model.firebaseRealtime.Sensor
import com.angel.airquality.viewModel.LocalSensorsViewModel

@Composable
fun DataViewer(
    context: MainActivity,
    localSensorsViewModel: LocalSensorsViewModel,
    sensor: MutableState<Sensor>
) {
    val alertLevelColor = when (sensor.value.value) {
        in 0..799 -> Color(0xFF43A047)
        in 800..1799 -> Color(0xFFFEDD33)
        else -> {
            Color(0xFFCB0033)
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(alertLevelColor.value), shape = CircleShape)
                .size(125.dp)
                .fillMaxHeight()
        ) {
            localSensorsViewModel.getSensor(context = context, sensor = sensor)
            Text(sensor.value.value.toString(), modifier = Modifier.align(Alignment.Center))
        }
        Text(text = sensor.value.time, textAlign = TextAlign.Center)
        Text(text = sensor.value.data, textAlign = TextAlign.Center)
    }
}