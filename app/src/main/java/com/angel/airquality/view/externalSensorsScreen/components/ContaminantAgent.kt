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
fun ContaminantAgent(text: String, modifier: Modifier) {

    Column(modifier = modifier) {
        Text(text, modifier = Modifier.align(Alignment.CenterHorizontally))
        Box(
            modifier = Modifier
                .background(color = Color.Green, shape = CircleShape)
                .size(50.dp)
        ) {
            Text("24", modifier = Modifier.align(Alignment.Center))
        }
    }
}