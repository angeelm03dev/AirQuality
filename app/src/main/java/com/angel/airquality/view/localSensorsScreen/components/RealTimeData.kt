package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.angel.airquality.viewModel.LocalSensorsViewModel

@Composable
fun RealTimeData(
    localSensorsViewModel: LocalSensorsViewModel,
    pollutionValue: MutableState<Int>,
    modifier: Modifier
){
    Column(modifier = modifier) {
        Row {
            DataViewer(pollutionValue = pollutionValue, localSensorsViewModel = localSensorsViewModel)
            DataExplanation(localSensorsViewModel = localSensorsViewModel)
        }
    }
}