package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angel.airquality.R
import com.angel.airquality.model.firebaseRealtime.Sensor
import com.angel.airquality.viewModel.LocalSensorsViewModel


@Composable
fun DataExplanation(sensor: MutableState<Sensor>) {

    val titleText = when (sensor.value.value) {
        in 0..799 -> stringResource(R.string.good_quality_title)
        in 800..1799 -> stringResource(R.string.regular_quality_title)
        else -> {
            stringResource(R.string.poor_quality_title)
        }
    }

    val descriptionText = when (sensor.value.value) {
        in 0..799 -> stringResource(R.string.good_quality_description)
        in 800..1799 -> stringResource(R.string.regular_quality_description)
        else -> {
            stringResource(R.string.poor_quality_description)
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