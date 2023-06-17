package com.angel.airquality.view.localSensorsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.view.localSensorsScreen.components.HistoryBox
import com.angel.airquality.view.localSensorsScreen.components.RealTimeData
import com.angel.airquality.view.localSensorsScreen.components.SensorName
import com.angel.airquality.viewModel.LocalSensorsViewModel
import kotlinx.coroutines.delay
import me.bytebeats.views.charts.line.LineChartData

@Composable
fun LocalSensorsScreen(
    context: MainActivity,
    innerPadding: PaddingValues
) {
    val localSensorsViewModel = viewModel<LocalSensorsViewModel>()

    LaunchedEffect(key1 = true) {
        while (true) {
            localSensorsViewModel.getSensor(context = context, sensor = GlobalVars.sensor)
            GlobalVars.mutableListPoint.add(
                LineChartData.Point(
                    GlobalVars.sensor.value.value.toFloat(),
                    GlobalVars.sensor.value.time
                )
            )
            if (GlobalVars.mutableListPoint.size > 10) {
                GlobalVars.mutableListPoint.removeRange(0, 1)
            }
            delay(3000)
        }
    }

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.primaryVariant)
            .fillMaxSize()
            .padding(innerPadding)
            .padding(10.dp),
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(color = MaterialTheme.colors.secondary)
                .padding(15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SensorName(
                modifier = Modifier.padding(top = 15.dp)
            )
            RealTimeData(
                context = context,
                localSensorsViewModel = localSensorsViewModel,
                sensor = GlobalVars.sensor,
                modifier = Modifier.fillMaxWidth()
            )
            HistoryBox(
                points = GlobalVars.points,
            )
        }

    }
}