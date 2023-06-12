package com.angel.airquality.view.localSensorsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.angel.airquality.view.localSensorsScreen.components.HistoryBox
import com.angel.airquality.view.localSensorsScreen.components.RealTimeData
import com.angel.airquality.view.localSensorsScreen.components.SensorName
import com.angel.airquality.viewModel.LocalSensorsViewModel

@Composable
fun LocalSensorsScreen(innerPadding: PaddingValues) {
    val localSensorsViewModel = viewModel<LocalSensorsViewModel>()
    val pollutionValue = remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .background(color = Color(0xFFEAF8FF))
            .fillMaxSize()
            .padding(innerPadding)
            .padding(10.dp),
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(color = Color(0xFFE4CCA7))
                .padding(15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                SensorName(localSensorsViewModel = localSensorsViewModel)
                Spacer(modifier = Modifier.width(5.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Cambiar de sensor")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Cambiar de sensor"
                    )
                }
            }
            RealTimeData(
                localSensorsViewModel = localSensorsViewModel,
                pollutionValue = pollutionValue,
                modifier = Modifier.fillMaxWidth()
            )
            HistoryBox(
                localSensorsViewModel = localSensorsViewModel,
                pollutionValue = pollutionValue
            )
        }

    }
}