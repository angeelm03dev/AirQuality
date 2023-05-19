package com.angel.airquality.view.externalSensorsScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.angel.airquality.view.externalSensorsScreen.components.ExternalSensorBox

@Composable
fun ExternalSensorsScreen(innerPadding: PaddingValues) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {

        //Nos traemos desde el ViewModel una List con los datos de cada tarjeta. Los extraeremos con un for-each
        items(20) {
            ExternalSensorBox(location = "Puente Genil", modifier = Modifier.padding(10.dp))
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun ExternalSensorsScreenPreview() {
    Scaffold() { innerPadding ->
        ExternalSensorsScreen(innerPadding = innerPadding)
    }
}