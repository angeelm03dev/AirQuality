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
import com.angel.airquality.viewModel.LocalSensorsViewModel

@Composable
fun DataViewer(localSensorsViewModel: LocalSensorsViewModel, pollutionValue: MutableState<Int>){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(0xFF43A047), shape = CircleShape)
                .size(125.dp)
                .fillMaxHeight()
        ) {
            localSensorsViewModel.getValue(pollutionValue)
            Text(pollutionValue.value.toString(), modifier = Modifier.align(Alignment.Center))
        }
        Text(text = "00:00", textAlign = TextAlign.Center)
        Text(text = "01/01/2000", textAlign = TextAlign.Center)
    }
}