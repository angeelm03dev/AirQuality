package com.angel.airquality.view.externalSensorsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GeneralPollutionIndex(location: String) {
    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            location,
            fontWeight = FontWeight.Medium,
            fontSize = 21.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 5.dp)
        )
        Box(
            modifier = Modifier
                .background(color = Color.Yellow, shape = CircleShape)
                .size(100.dp)
        ) {
            Text("24", modifier = Modifier.align(Alignment.Center))
        }

    }
}