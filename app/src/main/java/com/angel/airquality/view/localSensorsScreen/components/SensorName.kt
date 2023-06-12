package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angel.airquality.viewModel.LocalSensorsViewModel

@Composable
fun SensorName(localSensorsViewModel: LocalSensorsViewModel) {
    Text(
        text = "Habitación de invitados",
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp),
        textAlign = TextAlign.Center
    )
}