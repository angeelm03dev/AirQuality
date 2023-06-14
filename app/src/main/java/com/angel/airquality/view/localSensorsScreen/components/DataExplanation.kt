package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angel.airquality.model.firebaseRealtime.Sensor
import com.angel.airquality.viewModel.LocalSensorsViewModel


@Composable
fun DataExplanation(localSensorsViewModel: LocalSensorsViewModel, sensor: MutableState<Sensor>) {

    val titleText = when (sensor.value.value) {
        in 0..799 -> "Calidad buena ✅"
        in 800..1799 -> "Calidad regular ⚠️"
        else -> {
            "Calidad mala 🚩"
        }
    }

    val descriptionText = when (sensor.value.value) {
        in 0..799 -> "No debería haber peligro para la salud."
        in 800..1799 -> "Las personas con ciertas patologías podrían verse afectadas."
        else -> {
            "Ventile la zona donde se encuentra el sensor. Es posible que haya gases tóxicos en el área."
        }
    }

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = titleText,
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = descriptionText,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(10.dp),
            textAlign = TextAlign.Center
        )
    }
}