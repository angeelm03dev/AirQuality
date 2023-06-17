package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.angel.airquality.viewModel.LocalSensorsViewModel

@Composable
fun SensorName(modifier: Modifier) {
    Text(
        text = "Habitación de invitados",
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}