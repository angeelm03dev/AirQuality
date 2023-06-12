package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
fun DataExplanation(localSensorsViewModel: LocalSensorsViewModel) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calidad buena ✅",
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "La calidad del aire es buena y no debería producir problemas de salud",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(10.dp),
            textAlign = TextAlign.Center
        )
    }
}