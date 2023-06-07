package com.angel.airquality.view.externalSensorsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ContaminantAgent(type: String, value: Float, modifier: Modifier) {

    Column(modifier = modifier) {
        Text(type, modifier = Modifier.align(Alignment.CenterHorizontally))

        val alertLevelColor = when(value){
            in 0.0..50.0 -> Color(0xFF009866)
            in 51.0..100.0 -> Color(0xFFFEDD33)
            in 101.0..150.0 -> Color(0xFFFE9833)
            in 151.0..200.0 -> Color(0xFFCB0033)
            in 201.0..300.0 -> Color(0xFF660098)
            else -> { Color(0xFF7E0023) }
        }

        Box(
            modifier = Modifier
                .background(color = alertLevelColor, shape = CircleShape)
                .size(50.dp)
        ) {
            Text(value.toString(), modifier = Modifier.align(Alignment.Center))
        }
    }
}