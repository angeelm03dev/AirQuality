package com.angel.airquality.view.externalSensorsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ExternalSensorBox(location: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Gray)) {

        Text(location)
        Text("Aquí irian los datos relacionados con la contaminación")
    }
}

@Preview
@Composable
fun ExternalSensorBoxPreview(){
    ExternalSensorBox("Málaga")
}